package com.travellerybe.travel.application.dto.domain;

import com.travellerybe.picture.application.dto.response.PictureDto;
import com.travellerybe.travel.domain.LocationGroup;

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
}
