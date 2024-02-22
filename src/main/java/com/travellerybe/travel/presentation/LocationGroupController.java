package com.travellerybe.travel.presentation;

import com.travellerybe.travel.application.dto.request.RegisterLocationGroupReqDto;
import com.travellerybe.travel.application.service.LocationGroupService;
import com.travellerybe.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location-group")
@RequiredArgsConstructor
public class LocationGroupController {
    private final LocationGroupService locationGroupService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerLocationGroup(@AuthenticationPrincipal User user,
                                                        @RequestBody RegisterLocationGroupReqDto registerLocationReqGroupDto) {

        locationGroupService.registerLocationGroup(registerLocationReqGroupDto, user);
        return ResponseEntity.ok().body("Successfully registered");
    }
}
