package com.travellerybe.travel.presentation;

import com.travellerybe.travel.command.application.LocationGroupService;
import com.travellerybe.travel.command.dto.request.RegisterLocationGroupDto;
import com.travellerybe.user.command.domain.User;
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
    public ResponseEntity<String> registerLocationGroup(@AuthenticationPrincipal User user,
                                                        @RequestBody RegisterLocationGroupDto registerLocationGroupDto) {

        locationGroupService.registerLocationGroup(registerLocationGroupDto, user);
        return ResponseEntity.ok().body("HTTP_200_OK");
    }
}
