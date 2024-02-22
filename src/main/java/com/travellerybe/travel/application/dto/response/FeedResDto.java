package com.travellerybe.travel.application.dto.response;

import com.travellerybe.travel.application.dto.domain.FeedDto;

import java.util.List;

public record FeedResDto(
        List<FeedDto> feeds
) {
}
