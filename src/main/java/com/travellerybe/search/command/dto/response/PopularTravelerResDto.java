package com.travellerybe.search.command.dto.response;

import java.util.List;

public record PopularTravelerResDto(
        List<PopularTravelerDto> popularTravelers
) {
}