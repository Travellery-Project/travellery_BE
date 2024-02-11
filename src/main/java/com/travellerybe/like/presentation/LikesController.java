package com.travellerybe.like.presentation;

import com.travellerybe.travel.query.dto.response.TravelDto;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.like.command.application.LikesService;
import com.travellerybe.like.command.domain.Likes;
import com.travellerybe.like.query.dto.request.LikesReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
@Slf4j
public class LikesController {
    private final LikesService likesService;

    @GetMapping("")
    public ResponseEntity<Page<Likes>> getLikes(@AuthenticationPrincipal User user, Pageable pageable) {
        return ResponseEntity.ok().body(likesService.getLikes(user, pageable));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLikes(@AuthenticationPrincipal User user, @RequestBody LikesReqDto likesReqDto) {
        likesService.addLikes(user, likesReqDto.travelId());
        return ResponseEntity.ok().body("Successfully add " + likesReqDto.travelId() + " at likes list");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteLikes(@AuthenticationPrincipal User user, @RequestBody LikesReqDto likesReqDto) {
        likesService.deleteLikes(user, likesReqDto.travelId());
        return ResponseEntity.ok().body("Successfully delete " + likesReqDto.travelId() + " from likes list");
    }

    @GetMapping("/user")
    public ResponseEntity<List<TravelDto>> getUserLikedTravel(@AuthenticationPrincipal User user,
                                                              @SortDefault(sort = "createdDate", direction =
                                                                         Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(likesService.getUserLikedTravel(user, pageable));
    }
}
