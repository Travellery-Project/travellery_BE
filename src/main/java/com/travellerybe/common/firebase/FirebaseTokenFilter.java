package com.travellerybe.common.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.travellerybe.common.auth.CustomUserDetailService;
import com.travellerybe.common.auth.domain.FirebaseTokenClaim;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FirebaseTokenFilter extends OncePerRequestFilter {

    private final RedisTemplate<String, Object> redisTemplate;
    private final CustomUserDetailService customUserDetailService;
    private final FirebaseAuth firebaseAuth;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String idToken = header.substring(7);
        FirebaseTokenClaim firebaseTokenClaim = (FirebaseTokenClaim) redisTemplate.opsForValue().get(idToken);
        if (firebaseTokenClaim == null) {
            try {
                FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
                firebaseTokenClaim = FirebaseTokenClaim.fromFirebaseToken(decodedToken);

                redisTemplate.opsForValue().set(idToken, firebaseTokenClaim, getTokenExpiration(decodedToken), TimeUnit.SECONDS);
            } catch (FirebaseAuthException e) {
                log.error("FirebaseAuthException : {}", e.getMessage());
                setUnauthorizedResponse(response);
                return;
            }
        }

        UserDetails user = customUserDetailService.loadUserByUsername(firebaseTokenClaim.email());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private void setUnauthorizedResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"code\":\"" + "INVALID_TOKEN" + "\"}");
    }

    private Long getTokenExpiration(FirebaseToken decodedToken) {
        long expirationTime = (Long) decodedToken.getClaims().get("exp");
        long currentTime = System.currentTimeMillis() / 1000;
        return expirationTime - currentTime;
    }
}
