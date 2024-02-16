package com.travellerybe.travel.query.dto.response;

import java.util.List;

public record TravelDetailResDto(
        List<LocationGroupResDto> locationGroups,
        boolean isLiked
) {
}
