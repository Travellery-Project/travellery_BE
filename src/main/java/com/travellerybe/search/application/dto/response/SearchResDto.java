package com.travellerybe.search.application.dto.response;

import com.travellerybe.travel.application.dto.domain.FeedDto;

import java.util.List;

public record SearchResDto(
        List<FeedDto> travels,
        Long count
) {
}
