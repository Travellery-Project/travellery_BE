package com.travellerybe.travel.application.dto.mapper;

import com.travellerybe.search.domain.AutoCompletionType;
import com.travellerybe.search.application.dto.response.AutoComDestinationDto;
import com.travellerybe.search.application.dto.response.PopularDestinationDto;
import com.travellerybe.travel.domain.Destination;
import com.travellerybe.travel.application.dto.domain.DestinationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DestinationMapper {
    DestinationDto toDestinationDto(Destination destination);

    PopularDestinationDto toPopularDestinationDto(Destination destination);

    AutoComDestinationDto AutoCompDestinationDto(Destination destination, AutoCompletionType type);
}
