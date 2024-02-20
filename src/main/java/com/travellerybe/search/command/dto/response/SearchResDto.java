package com.travellerybe.search.command.dto.response;

import com.travellerybe.travel.command.dto.domain.FeedDto;

import java.util.List;

public record SearchResDto(
        List<FeedDto> travels,
        Long count
) {
}
