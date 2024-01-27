package com.travellerybe.travel.query.dto.request;

import com.travellerybe.travel.command.domain.LocationGroup;

public record RegisterLocationGroupDto(
        Long travelId,
        LocationGroup locationGroup
//        String address,
//        String location,
//        Date startDate,
//        Date endDate,
//        List<Picture> pictures,
//        String description,
//        SpecificLocation locationDetail
) {
}
