package com.travellerybe.search.command.dto.response;

import com.travellerybe.travel.command.domain.Destination;

public record AutoComDestinationDto(
        String name,
        String type
) {
    private static final String DESTINATION_TYPE = "destination" ;
    public static AutoComDestinationDto fromDestination(Destination destination){
        return new AutoComDestinationDto(destination.getName(), DESTINATION_TYPE);
    }
}
