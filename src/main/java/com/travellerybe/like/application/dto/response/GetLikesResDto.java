package com.travellerybe.like.application.dto.response;

import com.travellerybe.travel.domain.Travel;

import java.util.List;

public record GetLikesResDto(
        List<Travel> travel
) {
}
