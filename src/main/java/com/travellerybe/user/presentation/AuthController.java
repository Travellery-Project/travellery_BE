package com.travellerybe.user.presentation;

import com.google.firebase.auth.FirebaseAuthException;
import com.travellerybe.user.command.application.AuthService;
import com.travellerybe.user.query.dto.request.IdTokenDto;
import com.travellerybe.user.query.dto.response.SignInResDto;
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
    public ResponseEntity<SignInResDto> socialSignIn(@RequestBody IdTokenDto idTokenDto) throws FirebaseAuthException {
        return ResponseEntity.ok(authService.signIn(idTokenDto));
    }

    @GetMapping("/what")
    public ResponseEntity<Object> test() {
        return ResponseEntity.ok("test");
    }
}
