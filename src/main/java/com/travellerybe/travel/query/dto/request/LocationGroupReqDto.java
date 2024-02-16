package com.travellerybe.travel.query.dto.request;

import com.travellerybe.picture.query.dto.request.PictureReqDto;

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
