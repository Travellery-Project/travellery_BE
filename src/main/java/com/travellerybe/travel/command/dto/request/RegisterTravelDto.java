package com.travellerybe.travel.command.dto.request;

import lombok.Builder;

import java.util.Set;

public record RegisterTravelDto(
        String thumbnail,
        String title,
        String destination,
        Set<String> tags
) {
}
