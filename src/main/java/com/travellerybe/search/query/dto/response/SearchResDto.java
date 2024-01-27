package com.travellerybe.search.query.dto.response;

import com.travellerybe.travel.query.dto.response.TravelResDto;

import java.util.List;

public record SearchResDto(
        List<TravelResDto> travels,
        Long count
) {
}
