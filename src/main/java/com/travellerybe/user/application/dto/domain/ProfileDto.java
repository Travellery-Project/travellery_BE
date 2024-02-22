package com.travellerybe.user.application.dto.domain;

public record ProfileDto(
        Long id,
        String email,
        String username,
        String picture,
        String description,
        int travelCount,
        int pictureCount
) {
}
