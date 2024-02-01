package com.travellerybe.travel.query.dto.request;

import java.util.Date;
import java.util.List;

public record LocationGroupDto (
        String address,
        String location,
        Date startDate,
        Date endDate,
        List<PictureDto> pictures,
        String description,
        Double longitude,
        Double latitude,
        String specificLocation,
        String specificAddress
) {
}
