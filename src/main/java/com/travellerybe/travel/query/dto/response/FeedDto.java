package com.travellerybe.travel.query.dto.response;

import java.util.List;

public record FeedDto(
        List<TravelDto> feeds
) {
}
