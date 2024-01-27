package com.travellerybe.travel.query.dto.response;

import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.domain.Travel;

import java.time.LocalDateTime;
import java.util.List;

public record TravelResDto(
        Long id,
        LocalDateTime createdDate,
        String thumbnail,
        String title,
        List<String> tags,
        String destination,
        Boolean likes
) {
    public static TravelResDto fromTravel(Travel travel, Boolean likes) {
        return new TravelResDto(
                travel.getId(),
                travel.getCreatedDate(),
                travel.getThumbnail(),
                travel.getTitle(),
                travel.getTags().stream().map(Tag::getName).toList(),
                travel.getDestination().getName(),
                likes
        );
    }
}
