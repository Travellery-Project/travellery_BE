package com.travellerybe.travel.application.dto.response;

import com.travellerybe.travel.application.dto.domain.TravelDetailDto;

import java.util.List;

public record TravelDetailResDto(
        List<TravelDetailDto> locationGroups,
        boolean isLiked
) {
}
