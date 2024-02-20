package com.travellerybe.search.command.dto.domain.mapper;

import com.travellerybe.search.command.domain.SearchHistory;
import com.travellerybe.search.command.dto.domain.SearchHistoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchHistoryMapper {
    SearchHistoryDto toSearchHistoryDto(SearchHistory searchHistory);
}
