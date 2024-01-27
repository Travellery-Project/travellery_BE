package com.travellerybe.user.query.dto;

public record ProfileResDto(
        Long id,
        String email,
        String username,
        String picture,
        String description,
        int travelCount,
        int pictureCount
) {
}
