package com.travellerybe.user.application.dto.domain;

public record UserDto(
        Long id,
        String email,
        String username,
        String picture,
        String description
) {
}
