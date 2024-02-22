package com.travellerybe.travel.application.dto.domain;

import java.time.LocalDateTime;
import java.util.List;

public record FeedDto(
        Long id,
        LocalDateTime createdDate,
        String thumbnail,
        String title,
        String username,
        String userPicture,
        List<String> tags,
        String destination
) {
}
