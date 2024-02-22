package com.travellerybe.travel.presentation;

import com.travellerybe.travel.application.service.TravelService;
import com.travellerybe.travel.application.dto.request.RegisterTravelReqDto;
import com.travellerybe.travel.application.dto.response.FeedResDto;
import com.travellerybe.travel.application.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.application.dto.response.TravelDetailResDto;
import com.travellerybe.travel.application.dto.domain.FeedDto;
import com.travellerybe.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/travel")
@Slf4j
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/register")
    public ResponseEntity<RegisterTravelResDto> registerTravel(@AuthenticationPrincipal User user,
                                                               @RequestBody RegisterTravelReqDto registerTravelDto) {
        return ResponseEntity.ok().body(travelService.registerTravel(registerTravelDto, user));
    }

    @GetMapping("/feed/latest")
    public ResponseEntity<FeedResDto> getTravelFeed(@RequestParam(value = "cursor", required = false) String cursor) {
        return ResponseEntity.ok().body(travelService.getTravelFeed(cursor));
    }

    @GetMapping("/user")
    public ResponseEntity<List<FeedDto>> getUserTravelFeed(@AuthenticationPrincipal User user,
                                                           @SortDefault(sort = "createdDate", direction =
                                                                     Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(travelService.getUserTravels(user, pageable));
    }

    @GetMapping("/detail/{travelId}")
    public ResponseEntity<TravelDetailResDto> getTravelDetails(@AuthenticationPrincipal User user,
                                                               @PathVariable("travelId") Long travelId) {
        log.info(String.valueOf(travelId));
        return ResponseEntity.ok().body(travelService.getTravelDetails(user, travelId));
    }
}
