package com.travellerybe.travel.presentation;

import com.travellerybe.user.command.domain.User;
import com.travellerybe.travel.command.application.TravelService;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.query.dto.request.RegisterLocationGroupDto;
import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.PictureResDto;
import com.travellerybe.travel.query.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.query.dto.response.TravelResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/travel")
@Slf4j
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadPictures(@RequestParam(value = "files") MultipartFile[] files) {
        return ResponseEntity.ok().body(travelService.uploadGroupByLocation(files));
    }

    @PostMapping("/register/travel")
    public ResponseEntity<RegisterTravelResDto> registerTravel(@AuthenticationPrincipal User user,
                                                               @RequestBody RegisterTravelDto registerTravelDto) {
        return ResponseEntity.ok().body(travelService.registerTravel(registerTravelDto, user));
    }

    @PostMapping("/register/location-group")
    public ResponseEntity<String> registerLocationGroup(@AuthenticationPrincipal User user,
                                                        @RequestBody RegisterLocationGroupDto registerLocationGroupDto) {
        log.info(registerLocationGroupDto.locationGroup().getSpecificLocation());

        travelService.registerLocationGroup(registerLocationGroupDto, user);
        return ResponseEntity.ok().body("HTTP_200_OK");
    }

    @GetMapping("/feed/latest")
    public ResponseEntity<List<TravelResDto>> getTravelFeed(@AuthenticationPrincipal User user,
                                                            @SortDefault(sort = "createdDate", direction =
                                                                        Sort.Direction.DESC) Pageable pageable) {
        if (user == null) {
            return ResponseEntity.ok().body(travelService.getTravelFeed(pageable));
        }
        return ResponseEntity.ok().body(travelService.getTravelFeed(pageable, user));
    }

    @GetMapping("/user")
    public ResponseEntity<List<TravelResDto>> getUserTravelFeed(@AuthenticationPrincipal User user,
                                                                @SortDefault(sort = "createdDate", direction =
                                                                            Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(travelService.getUserTravels(user, pageable));
    }

    @GetMapping("/picture/user")
    public ResponseEntity<List<PictureResDto>> getUserPictures(@AuthenticationPrincipal User user,
                                                               @SortDefault(sort = "createdDate", direction =
                                                                       Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(travelService.getUserPictures(user, pageable));
    }

    @GetMapping("/likes/user")
    public ResponseEntity<List<TravelResDto>> getUserLikesTravel(@AuthenticationPrincipal User user,
                                                                 @SortDefault(sort = "createdDate", direction =
                                                                         Sort.Direction.DESC) Pageable pageable) {
        log.info("is it work?");
        return ResponseEntity.ok().body(travelService.getUserLikesTravel(user, pageable));
    }

    @GetMapping("/detail/{travelId}")
    public ResponseEntity<List<LocationGroup>> getTravelDetails(@PathVariable("travelId") Long travelId) {
        log.info(String.valueOf(travelId));
        return ResponseEntity.ok().body(travelService.getTravelDetails(travelId));
    }
}
