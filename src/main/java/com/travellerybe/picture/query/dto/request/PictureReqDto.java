package com.travellerybe.picture.query.dto.request;

import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.picture.command.domain.Picture;
import com.travellerybe.user.command.domain.User;

import java.util.Date;

public record PictureReqDto(
        String path,
        Date date,
        String name,
        String mime
) {
    public Picture toEntityWithUserAndLocationGroup(User user, LocationGroup locationGroup){
        return Picture.builder()
                .name(this.name())
                .date(this.date())
                .path(this.path())
                .mime(this.mime())
                .locationGroup(locationGroup)
                .user(user)
                .build();
    }
}
