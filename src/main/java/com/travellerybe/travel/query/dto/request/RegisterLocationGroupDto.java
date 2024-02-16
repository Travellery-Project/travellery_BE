package com.travellerybe.travel.query.dto.request;

import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Travel;

public record RegisterLocationGroupDto(
        Long travelId,
        LocationGroupReqDto locationGroup
) {
    public LocationGroup toEntityWithTravel(Travel travel) {
        return LocationGroup.builder()
                .location(this.locationGroup().location())
                .travel(travel)
                .startDate(this.locationGroup().startDate())
                .endDate(this.locationGroup().endDate())
                .address(this.locationGroup().address())
                .description(this.locationGroup().description())
                .latitude(this.locationGroup().latitude())
                .longitude(this.locationGroup().longitude())
                .specificLocation(this.locationGroup().specificLocation())
                .specificAddress(this.locationGroup().specificAddress())
                .build();
    }
}
