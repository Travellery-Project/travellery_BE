package com.travellerybe.travel.command.dto.domain.mapper;

import com.travellerybe.search.command.domain.AutoCompletionType;
import com.travellerybe.search.command.dto.response.AutoComTagDto;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.dto.domain.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
   TagDto toTagDto(Tag tag);

   AutoComTagDto toAutoComTagDto(Tag tag, AutoCompletionType type);
}
