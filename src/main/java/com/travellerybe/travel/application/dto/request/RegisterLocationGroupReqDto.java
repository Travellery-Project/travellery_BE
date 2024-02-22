package com.travellerybe.travel.application.dto.request;

public record RegisterLocationGroupReqDto(
        Long travelId,
        LocationGroupReqDto locationGroup
) {
}
