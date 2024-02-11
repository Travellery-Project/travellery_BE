package com.travellerybe.picture.presentation;

import com.travellerybe.picture.command.application.PictureService;
import com.travellerybe.picture.query.dto.response.PictureResDto;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadPictures(@RequestParam(value = "files") MultipartFile[] files) {
        return ResponseEntity.ok().body(pictureService.uploadGroupByLocationPictures(files));
    }

    @GetMapping("/user")
    public ResponseEntity<List<PictureResDto>> getUserPictures(@AuthenticationPrincipal User user,
                                                               @SortDefault(sort = "createdDate", direction =
                                                                       Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(pictureService.getUserPictures(user, pageable));
    }
}
