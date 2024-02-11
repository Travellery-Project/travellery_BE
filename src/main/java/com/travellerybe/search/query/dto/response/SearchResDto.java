package com.travellerybe.search.query.dto.response;

import com.travellerybe.travel.query.dto.response.TravelDto;

import java.util.List;

public record SearchResDto(
        List<TravelDto> travels,
        Long count
) {
}
