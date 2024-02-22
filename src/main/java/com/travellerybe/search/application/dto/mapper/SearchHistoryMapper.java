package com.travellerybe.search.application.dto.mapper;

import com.travellerybe.search.application.dto.domain.SearchHistoryDto;
import com.travellerybe.search.domain.SearchHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchHistoryMapper {
    SearchHistoryDto toSearchHistoryDto(SearchHistory searchHistory);
}
