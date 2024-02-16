package com.travellerybe.picture.query.dto.response;

import com.travellerybe.picture.command.domain.Picture;

import java.util.Date;

public record PictureResDto(
        Long id,
        String path,
        Date date,
        String name,
        String mime
) {
    public static PictureResDto fromPicture(Picture picture) {
        return new PictureResDto(picture.getId(),
                picture.getPath(),
                picture.getDate(),
                picture.getName(),
                picture.getMime());
    }
}
