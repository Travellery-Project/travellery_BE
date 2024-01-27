package com.travellerybe.user.presentation;

import com.travellerybe.user.command.application.AuthService;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.query.dto.SignInResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    /**
     * 로그인
     * 로그아웃
     * Oauth 처리
     *
     */
    @GetMapping
    public Object sayHello(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @GetMapping("/sign-in/social/google")
    public ResponseEntity<SignInResDto> socialSignIn(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(authService.signIn(user));
    }
}
