package com.travellerybe.travel.application.dto.mapper;

import com.travellerybe.picture.application.dto.response.PictureDto;
import com.travellerybe.travel.application.dto.domain.TravelDetailDto;
import com.travellerybe.travel.domain.LocationGroup;
import com.travellerybe.travel.domain.Travel;
import com.travellerybe.travel.application.dto.request.LocationGroupReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationGroupMapper {
    TravelDetailDto toTravelDetailDto(LocationGroup locationGroup, List<PictureDto> pictures);

    @Mapping(target = "pictures", ignore = true)
    LocationGroup fromLocationGroupReqDto(LocationGroupReqDto locationGroupReqDto, Travel travel);
}
