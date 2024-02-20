package com.travellerybe.search.command.dto.response;

import java.util.List;

public record AutoCompletionResDto(
        List<AutoComUserDto> users,
        List<AutoComTagDto> tags,
        List<AutoComDestinationDto> destinations
) {
}
