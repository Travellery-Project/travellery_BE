package com.travellerybe.user.presentation;

import com.google.firebase.auth.FirebaseAuthException;
import com.travellerybe.user.command.application.AuthService;
import com.travellerybe.user.command.dto.domain.UserDto;
import com.travellerybe.user.command.dto.request.IdTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in/social/google")
    public ResponseEntity<UserDto> socialSignIn(@RequestBody IdTokenDto idTokenDto) throws FirebaseAuthException {
        return ResponseEntity.ok(authService.signIn(idTokenDto));
    }
}
