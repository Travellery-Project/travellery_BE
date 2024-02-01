package com.travellerybe.travel.query.dto.request;

import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Picture;
import com.travellerybe.user.command.domain.User;

import java.util.Date;

public record PictureDto(
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
