package com.travellerybe.search.command.dto.response;

import com.travellerybe.search.command.domain.AutoCompletionType;

public record AutoComUserDto(
        String name,
        String picture,
        AutoCompletionType type
) {
}
