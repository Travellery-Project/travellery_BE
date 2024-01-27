package com.travellerybe.user.query.dto;

public record SignInResDto(
        Long id,
        String email,
        String username,
        String picture,
        String description
) {
}
