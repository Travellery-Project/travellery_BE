package com.travellerybe.travel.application.dto.request;

import java.util.Set;

public record RegisterTravelReqDto(
        String thumbnail,
        String title,
        String destination,
        Set<String> tags
) {
}
