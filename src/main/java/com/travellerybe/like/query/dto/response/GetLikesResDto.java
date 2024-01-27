package com.travellerybe.like.query.dto.response;

import com.travellerybe.travel.command.domain.Travel;

import java.util.List;

public record GetLikesResDto(
        List<Travel> travel
) {
}
