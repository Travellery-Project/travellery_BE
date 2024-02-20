package com.travellerybe.search.command.dto.response;

import com.travellerybe.search.command.dto.domain.SearchHistoryDto;

import java.util.List;

public record SearchHistoryResDto(
        List<SearchHistoryDto> searchHistories
) {
}
