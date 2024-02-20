package com.travellerybe.travel.command.dto.request;

import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Travel;

public record RegisterLocationGroupDto(
        Long travelId,
        LocationGroupReqDto locationGroup
) {
}
