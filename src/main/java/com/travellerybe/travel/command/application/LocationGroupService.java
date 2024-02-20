package com.travellerybe.travel.command.application;

import com.travellerybe.picture.command.domain.Picture;
import com.travellerybe.picture.command.dto.domain.mapper.PictureMapper;
import com.travellerybe.picture.query.dto.request.PictureReqDto;
import com.travellerybe.picture.query.repository.PictureRepository;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.command.dto.domain.mapper.LocationGroupMapper;
import com.travellerybe.travel.command.dto.request.LocationGroupReqDto;
import com.travellerybe.travel.command.dto.request.RegisterLocationGroupDto;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.travel.repository.LocationGroupRepository;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.travellerybe.travel.exception.TravelExceptionType.NOT_FOUND_TRAVEL;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationGroupService {
    private final TravelRepository travelRepository;
    private final LocationGroupRepository locationGroupRepository;
    private final PictureRepository pictureRepository;
    private final LocationGroupMapper locationGroupMapper;
    private final PictureMapper pictureMapper;

    @Transactional
    public void registerLocationGroup(RegisterLocationGroupDto registerLocationGroupDto, User user) {

        Travel travel = travelRepository.findById(registerLocationGroupDto.travelId())
                .orElseThrow(() -> new TravelException(NOT_FOUND_TRAVEL));

        LocationGroupReqDto locationGroupReqDto = registerLocationGroupDto.locationGroup();
        LocationGroup locationGroup = locationGroupRepository.save(locationGroupMapper.fromLocationGroupReqDto(
                locationGroupReqDto, travel));

        List<PictureReqDto> picturesReqDtos = locationGroupReqDto.pictures();
        List<Picture> pictures = picturesReqDtos.stream().map(pictureReqDto ->
                pictureMapper.fromPictureReqDto(pictureReqDto, locationGroup, user)).toList();

        pictureRepository.saveAll(pictures);
    }
}
