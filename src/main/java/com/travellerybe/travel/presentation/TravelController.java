package com.travellerybe.travel.presentation;

import com.travellerybe.travel.query.dto.response.FeedDto;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.travel.command.application.TravelService;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.query.dto.response.TravelDto;
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
                                                               @RequestBody RegisterTravelDto registerTravelDto) {
        return ResponseEntity.ok().body(travelService.registerTravel(registerTravelDto, user));
    }

    @GetMapping("/feed/latest")
    public ResponseEntity<FeedDto> getTravelFeed(@AuthenticationPrincipal User user,
                                                 @RequestParam(value = "cursor", required = false) String cursor) {
        return ResponseEntity.ok().body(travelService.getTravelFeed(cursor));
    }

    @GetMapping("/user")
    public ResponseEntity<List<TravelDto>> getUserTravelFeed(@AuthenticationPrincipal User user,
                                                             @SortDefault(sort = "createdDate", direction =
                                                                            Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(travelService.getUserTravels(user, pageable));
    }

    @GetMapping("/detail/{travelId}")
    public ResponseEntity<List<LocationGroup>> getTravelDetails(@PathVariable("travelId") Long travelId) {
        log.info(String.valueOf(travelId));
        return ResponseEntity.ok().body(travelService.getTravelDetails(travelId));
    }
}
