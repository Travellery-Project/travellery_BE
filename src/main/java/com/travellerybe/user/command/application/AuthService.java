package com.travellerybe.user.command.application;


import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.query.dto.SignInResDto;
import com.travellerybe.user.query.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    UserRepository userRepository;

    public SignInResDto signIn(User user) {
        return new SignInResDto(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getPicture(),
                user.getDescription()
        );
    }

}
