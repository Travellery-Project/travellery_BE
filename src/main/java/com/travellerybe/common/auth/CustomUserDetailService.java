package com.travellerybe.common.auth;

import com.travellerybe.common.auth.domain.FirebaseTokenClaim;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.repository.UserRepository;
import com.travellerybe.user.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.travellerybe.user.exception.AuthExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email){
        log.info("loadUserByUsername");
        User user = userRepository.findByEmail(email).orElseThrow(() -> new AuthException(NOT_FOUND_MEMBER));
        user.initializeTravels();
        return user;
    }

    @Transactional
    public User registerNewUser(FirebaseTokenClaim firebaseTokenClaim) {
        return userRepository.save(User.builder()
                        .username(firebaseTokenClaim.name())
                        .email(firebaseTokenClaim.email())
                        .picture(firebaseTokenClaim.picture())
                .build());
    }
}
