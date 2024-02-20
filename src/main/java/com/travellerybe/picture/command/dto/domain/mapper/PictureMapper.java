package com.travellerybe.picture.command.dto.domain.mapper;

import com.travellerybe.picture.command.domain.Picture;
import com.travellerybe.picture.query.dto.request.PictureReqDto;
import com.travellerybe.picture.query.dto.response.PictureDto;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.user.command.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    PictureDto toPictureDto(Picture picture);

    Picture fromPictureReqDto(PictureReqDto pictureRegisterReqDto, LocationGroup locationGroup,
                              User user);
}
