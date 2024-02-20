package com.travellerybe.user.command.dto.domain;

public record UserDto(
        Long id,
        String email,
        String username,
        String picture,
        String description
) {
}
