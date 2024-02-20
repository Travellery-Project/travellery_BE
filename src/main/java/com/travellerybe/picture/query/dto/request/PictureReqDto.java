package com.travellerybe.picture.query.dto.request;

import java.util.Date;

public record PictureReqDto(
        String path,
        Date date,
        String name,
        String mime
) {
}
