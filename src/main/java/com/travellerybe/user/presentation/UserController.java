package com.travellerybe.user.presentation;

import com.travellerybe.user.command.application.UserService;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.query.dto.request.ModifyProfileReqDto;
import com.travellerybe.user.query.dto.ProfileResDto;
import com.travellerybe.user.query.dto.SignInResDto;
import com.travellerybe.user.query.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/profile")
    public ResponseEntity<ProfileResDto> getUserProfile(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok().body(
                userService.getUserProfile(user)
        );
    }

    @PostMapping("/modify/picture")
    public void modifyPicture(@AuthenticationPrincipal User user,
                              @RequestParam(value = "file") MultipartFile[] file) {
        MultipartFile newFile = file[0];
        userService.modifyUserPicture(user, newFile);
    }

    @PostMapping("/modify/profile")
    public ResponseEntity<SignInResDto> modifyUserProfile(@AuthenticationPrincipal User user,
                                                          @RequestBody ModifyProfileReqDto modifyProfileReqDto) {

        return ResponseEntity.ok().body(userService.modifyUserProfile(user, modifyProfileReqDto));
    }
}
