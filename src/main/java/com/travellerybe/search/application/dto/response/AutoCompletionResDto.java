package com.travellerybe.search.application.dto.response;

import java.util.List;

public record AutoCompletionResDto(
        List<AutoComUserDto> users,
        List<AutoComTagDto> tags,
        List<AutoComDestinationDto> destinations
) {
}
