package com.travellerybe.travel.command.dto.response;

import com.travellerybe.travel.command.dto.domain.TravelDetailDto;

import java.util.List;

public record TravelDetailResDto(
        List<TravelDetailDto> locationGroups,
        boolean isLiked
) {
}
