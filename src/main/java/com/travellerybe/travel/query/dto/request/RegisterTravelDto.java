package com.travellerybe.travel.query.dto.request;

import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record RegisterTravelDto(
        String thumbnail,
        String title,
        String destination,
        Set<String> tags
) {
}
