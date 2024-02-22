package com.travellerybe.search.application.dto.response;

import com.travellerybe.search.application.dto.domain.SearchHistoryDto;

import java.util.List;

public record SearchHistoryResDto(
        List<SearchHistoryDto> searchHistories
) {
}
