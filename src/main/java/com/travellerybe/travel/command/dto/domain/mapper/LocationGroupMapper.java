package com.travellerybe.travel.command.dto.domain.mapper;

import com.travellerybe.picture.query.dto.response.PictureDto;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.command.dto.domain.TravelDetailDto;
import com.travellerybe.travel.command.dto.request.LocationGroupReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationGroupMapper {
    TravelDetailDto toTravelDetailDto(LocationGroup locationGroup, List<PictureDto> pictures);

    @Mapping(target = "pictures", ignore = true)
    LocationGroup fromLocationGroupReqDto(LocationGroupReqDto locationGroupReqDto, Travel travel);
}
