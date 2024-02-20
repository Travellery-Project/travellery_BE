package com.travellerybe.travel.command.dto.domain.mapper;

import com.travellerybe.search.command.domain.AutoCompletionType;
import com.travellerybe.search.command.dto.response.AutoComDestinationDto;
import com.travellerybe.search.command.dto.response.PopularDestinationDto;
import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.dto.domain.DestinationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DestinationMapper {
    DestinationDto toDestinationDto(Destination destination);

    PopularDestinationDto toPopularDestinationDto(Destination destination);

    AutoComDestinationDto AutoCompDestinationDto(Destination destination, AutoCompletionType type);
}
