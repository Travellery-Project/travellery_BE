package com.travellerybe.travel.query.dto.response;

import com.travellerybe.like.command.domain.Likes;
import com.travellerybe.travel.command.domain.Travel;

public record TravelWithUserLikesDto(
        Travel travel,
        Likes likes
) {
    public boolean isLiked() {
        return likes != null;
    }
}
