package com.travellerybe.travel.application.service;

import com.travellerybe.picture.domain.Picture;
import com.travellerybe.picture.application.dto.mapper.PictureMapper;
import com.travellerybe.picture.application.dto.request.PictureReqDto;
import com.travellerybe.picture.repository.PictureRepository;
import com.travellerybe.travel.domain.LocationGroup;
import com.travellerybe.travel.domain.Travel;
import com.travellerybe.travel.application.dto.mapper.LocationGroupMapper;
import com.travellerybe.travel.application.dto.request.LocationGroupReqDto;
import com.travellerybe.travel.application.dto.request.RegisterLocationGroupReqDto;
import com.travellerybe.travel.application.exception.TravelException;
import com.travellerybe.travel.repository.LocationGroupRepository;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.travellerybe.travel.application.exception.TravelExceptionType.NOT_FOUND_TRAVEL;

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
    public void registerLocationGroup(RegisterLocationGroupReqDto registerLocationGroupReqDto, User user) {

        Travel travel = travelRepository.findById(registerLocationGroupReqDto.travelId())
                .orElseThrow(() -> new TravelException(NOT_FOUND_TRAVEL));

        LocationGroupReqDto locationGroupReqDto = registerLocationGroupReqDto.locationGroup();
        LocationGroup locationGroup = locationGroupRepository.save(locationGroupMapper.fromLocationGroupReqDto(
                locationGroupReqDto, travel));

        List<PictureReqDto> picturesReqDtos = locationGroupReqDto.pictures();
        List<Picture> pictures = picturesReqDtos.stream().map(pictureReqDto ->
                pictureMapper.fromPictureReqDto(pictureReqDto, locationGroup, user)).toList();

        pictureRepository.saveAll(pictures);
    }
}
