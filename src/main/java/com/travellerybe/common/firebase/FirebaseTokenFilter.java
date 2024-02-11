package com.travellerybe.common.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.travellerybe.user.exception.AuthException;
import com.travellerybe.common.auth.CustomUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FirebaseTokenFilter extends OncePerRequestFilter {

    private final CustomUserDetailService customUserDetailService;
    private final FirebaseAuth firebaseAuth;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        FirebaseToken decodedToken;
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
//            setUnauthorizedResponse(response, "INVALID_HEADER");
            filterChain.doFilter(request, response);
            return;
        }
        String idToken = header.substring(7);
        log.info("id token: {}", idToken);

        try {
            decodedToken = firebaseAuth.verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            log.error("FirebaseAuthException : {}", e.getMessage());
            setUnauthorizedResponse(response);
            return;
        }

        try {
            UserDetails user = customUserDetailService.loadUserByUsername(decodedToken.getEmail());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (AuthException e) {
            UserDetails user = customUserDetailService.registerNewUser(decodedToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        filterChain.doFilter(request, response);
    }

    private void setUnauthorizedResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"code\":\"" + "INVALID_TOKEN" + "\"}");
    }
}
