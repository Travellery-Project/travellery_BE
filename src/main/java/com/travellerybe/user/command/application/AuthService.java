package com.travellerybe.user.command.application;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.command.dto.domain.UserDto;
import com.travellerybe.user.command.dto.domain.mapper.UserMapper;
import com.travellerybe.user.exception.AuthException;
import com.travellerybe.user.command.dto.request.IdTokenDto;
import com.travellerybe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

import static com.travellerybe.user.exception.AuthExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthService {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int LENGTH = 6;

    private final FirebaseAuth firebaseAuth;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDto signIn(IdTokenDto idToken) throws FirebaseAuthException {
        FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken.idToken());
        String email = decodedToken.getEmail();

        if (!userRepository.existsByEmail(email)) {
            registerUser(decodedToken);
        }
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthException(NOT_FOUND_MEMBER));

        return userMapper.toUserDto(user);
    }

    private void registerUser(FirebaseToken decodedToken) {
        String username = generateUsernameWithRandomTag(decodedToken.getName());

        userRepository.save(User.builder()
                .email(decodedToken.getEmail())
                .picture(decodedToken.getPicture())
                .username(username)
                .build());
    }

    private String generateUsernameWithRandomTag(String name) {
        StringBuilder randomString = new StringBuilder(LENGTH);

        while (true) {
            randomString.setLength(0);
            for (int i = 0; i < LENGTH; i++) {
                int randomIndex = RANDOM.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                randomString.append(randomChar);
            }
            String username = name + "#" + randomString;

            if (!userRepository.existsByUsername(username)) {
                return username;
            }
        }
    }
}
