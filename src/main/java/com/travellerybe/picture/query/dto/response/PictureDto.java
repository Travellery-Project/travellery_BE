package com.travellerybe.picture.query.dto.response;

import com.travellerybe.picture.command.domain.Picture;

import java.util.Date;

public record PictureDto(
        Long id,
        String path,
        Date date,
        String name,
        String mime
) {
    public static PictureDto fromPicture(Picture picture) {
        return new PictureDto(picture.getId(),
                picture.getPath(),
                picture.getDate(),
                picture.getName(),
                picture.getMime());
    }
}
