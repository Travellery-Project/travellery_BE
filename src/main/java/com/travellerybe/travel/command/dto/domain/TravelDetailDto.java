package com.travellerybe.travel.command.dto.domain;

import com.travellerybe.picture.query.dto.response.PictureDto;
import com.travellerybe.travel.command.domain.LocationGroup;

import java.util.Date;
import java.util.List;

public record TravelDetailDto(
        String description,
        String address,
        String location,
        Date startDate,
        Date endDate,
        Double latitude,
        Double longitude,
        String specificLocation,
        String specificAddress,
        List<PictureDto> pictures
) {
    public static TravelDetailDto fromLocationGroup(LocationGroup locationGroup, List<PictureDto> pictures) {
        return new TravelDetailDto(locationGroup.getDescription(),
                locationGroup.getAddress(),
                locationGroup.getLocation(),
                locationGroup.getStartDate(),
                locationGroup.getEndDate(),
                locationGroup.getLatitude(),
                locationGroup.getLongitude(),
                locationGroup.getSpecificLocation(),
                locationGroup.getSpecificAddress(),
                pictures);
    }
}
