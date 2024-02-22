package com.travellerybe.search.application.dto.response;

import com.travellerybe.search.domain.AutoCompletionType;

public record AutoComUserDto(
        String name,
        String picture,
        AutoCompletionType type
) {
}
