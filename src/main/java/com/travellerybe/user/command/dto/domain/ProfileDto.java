package com.travellerybe.user.command.dto.domain;

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
