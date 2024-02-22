package com.travellerybe.picture.application.dto.mapper;

import com.travellerybe.picture.application.dto.request.PictureReqDto;
import com.travellerybe.picture.application.dto.response.PictureDto;
import com.travellerybe.picture.domain.Picture;
import com.travellerybe.travel.domain.LocationGroup;
import com.travellerybe.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    PictureDto toPictureDto(Picture picture);

    Picture fromPictureReqDto(PictureReqDto pictureRegisterReqDto, LocationGroup locationGroup,
                              User user);
}
