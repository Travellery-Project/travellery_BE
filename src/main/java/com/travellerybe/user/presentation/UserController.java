package com.travellerybe.user.presentation;

import com.travellerybe.user.application.service.UserService;
import com.travellerybe.user.domain.User;
import com.travellerybe.user.application.dto.domain.UserDto;
import com.travellerybe.user.application.dto.request.ModifyProfileReqDto;
import com.travellerybe.user.application.dto.domain.ProfileDto;
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

    @GetMapping("/profile")
    public ResponseEntity<ProfileDto> getUserProfile(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok().body(userService.getUserProfile(user));
    }

    @PostMapping("/modify/picture")
    public ResponseEntity<Object> modifyPicture(@AuthenticationPrincipal User user,
                              @RequestParam(value = "file") MultipartFile[] file) {
        MultipartFile newFile = file[0];
        userService.modifyUserPicture(user, newFile);
        return ResponseEntity.ok().body("프로필 이미지 변경에 성공하였습니다.");
    }

    @PostMapping("/modify/profile")
    public ResponseEntity<UserDto> modifyUserProfile(@AuthenticationPrincipal User user,
                                                     @RequestBody ModifyProfileReqDto modifyProfileReqDto) {

        return ResponseEntity.ok().body(userService.modifyUserProfile(user, modifyProfileReqDto));
    }
}
