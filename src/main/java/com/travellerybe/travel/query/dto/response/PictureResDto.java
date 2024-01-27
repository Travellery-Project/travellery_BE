package com.travellerybe.travel.query.dto.response;

import java.util.Date;

public record PictureResDto(
        Long id,
        String path,
        Date date,
        String name,
        String mime
) {
}
