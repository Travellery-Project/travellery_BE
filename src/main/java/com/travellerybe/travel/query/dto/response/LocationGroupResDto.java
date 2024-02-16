package com.travellerybe.travel.query.dto.response;

import com.travellerybe.picture.query.dto.response.PictureResDto;
import com.travellerybe.travel.command.domain.LocationGroup;

import java.util.Date;
import java.util.List;

public record LocationGroupResDto(
        String description,
        String address,
        String location,
        Date startDate,
        Date endDate,
        Double latitude,
        Double longitude,
        String specificLocation,
        String specificAddress,
        List<PictureResDto> pictures
) {
    public static LocationGroupResDto fromLocationGroup(LocationGroup locationGroup, List<PictureResDto> pictures) {
        return new LocationGroupResDto(locationGroup.getDescription(),
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
