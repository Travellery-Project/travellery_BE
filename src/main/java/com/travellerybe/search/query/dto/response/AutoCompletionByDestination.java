package com.travellerybe.search.query.dto.response;

import com.travellerybe.travel.command.domain.Destination;

public record AutoCompletionByDestination(
        String name,
        String type
) {
    private static final String DESTINATION_TYPE = "destination" ;
    public static AutoCompletionByDestination fromDestination(Destination destination){
        return new AutoCompletionByDestination(destination.getName(), DESTINATION_TYPE);
    }
}
