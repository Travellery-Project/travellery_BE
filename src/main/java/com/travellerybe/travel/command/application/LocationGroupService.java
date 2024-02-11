package com.travellerybe.travel.command.application;

import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.picture.command.domain.Picture;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.picture.query.dto.request.PictureReqDto;
import com.travellerybe.travel.query.dto.request.RegisterLocationGroupDto;
import com.travellerybe.travel.query.repository.LocationGroupRepository;
import com.travellerybe.picture.query.repository.PictureRepository;
import com.travellerybe.travel.query.repository.TravelRepository;
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

    @Transactional
    public void registerLocationGroup(RegisterLocationGroupDto registerLocationGroupDto, User user) {
        Travel travel = travelRepository.findById(registerLocationGroupDto.travelId())
                .orElseThrow(() -> new TravelException(NOT_FOUND_TRAVEL));

        LocationGroup locationGroup = locationGroupRepository.save(registerLocationGroupDto.toEntityWithTravel(travel));

        List<PictureReqDto> picturesDto = registerLocationGroupDto.locationGroup().pictures();
        List<Picture> pictures = picturesDto.stream().map(picture ->
                picture.toEntityWithUserAndLocationGroup(user, locationGroup)).toList();

        pictureRepository.saveAll(pictures);
    }

}
