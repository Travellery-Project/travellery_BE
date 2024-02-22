package com.travellerybe.travel.application.dto.mapper;

import com.travellerybe.search.domain.AutoCompletionType;
import com.travellerybe.search.application.dto.response.AutoComTagDto;
import com.travellerybe.travel.domain.Tag;
import com.travellerybe.travel.application.dto.domain.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
   TagDto toTagDto(Tag tag);

   AutoComTagDto toAutoComTagDto(Tag tag, AutoCompletionType type);
}
