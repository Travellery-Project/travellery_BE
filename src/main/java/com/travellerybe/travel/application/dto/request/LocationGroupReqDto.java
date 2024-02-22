package com.travellerybe.travel.application.dto.request;

import com.travellerybe.picture.application.dto.request.PictureReqDto;

import java.util.Date;
import java.util.List;

public record LocationGroupReqDto(
        String address,
        String location,
        Date startDate,
        Date endDate,
        List<PictureReqDto> pictures,
        String description,
        Double longitude,
        Double latitude,
        String specificLocation,
        String specificAddress
) {
}
