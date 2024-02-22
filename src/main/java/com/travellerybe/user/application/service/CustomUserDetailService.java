package com.travellerybe.user.application.service;

import com.travellerybe.user.domain.User;
import com.travellerybe.user.repository.UserRepository;
import com.travellerybe.user.application.exception.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.travellerybe.user.application.exception.AuthExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    @Cacheable("loadUserByUsername")
    public User loadUserByUsername(String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new AuthException(NOT_FOUND_MEMBER));
        user.initializeTravels();
        return user;
    }
}
