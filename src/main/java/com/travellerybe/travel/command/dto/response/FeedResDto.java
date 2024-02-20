package com.travellerybe.travel.command.dto.response;

import com.travellerybe.travel.command.dto.domain.FeedDto;

import java.util.List;

public record FeedResDto(
        List<FeedDto> feeds
) {
}
