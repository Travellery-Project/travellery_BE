package com.travellerybe.travel.command.application;

import com.travellerybe.like.query.repository.LikesRepository;
import com.travellerybe.picture.query.dto.response.PictureResDto;
import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.*;
import com.travellerybe.travel.query.repository.DestinationRepository;
import com.travellerybe.travel.query.repository.LocationGroupRepository;
import com.travellerybe.travel.query.repository.TagRepository;
import com.travellerybe.travel.query.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TravelService {
    private final String CURSOR_LATEST = "latest";
    private final LikesRepository likesRepository;

    private final DestinationRepository destinationRepository;
    private final TagRepository tagsRepository;
    private final LocationGroupRepository locationGroupRepository;
    private final TravelRepository travelRepository;

    @Transactional
    @CacheEvict(value = "travelFeedLatest", key = "'latest'")
    public RegisterTravelResDto registerTravel(RegisterTravelDto registerTravelDto, User user) {

        Set<Tag> tags = registerTravelDto.tags().stream().map(tagName ->
                tagsRepository.findByName(tagName).orElseGet(() ->
                        tagsRepository.save(Tag.builder()
                                .name(tagName)
                                .build()
                        )
                )
        ).collect(Collectors.toSet());

        Optional<Destination> existingDestination = destinationRepository.findByName(registerTravelDto.destination());

        Destination destination = existingDestination.orElseGet(() ->
                destinationRepository.save(Destination.builder()
                        .name(registerTravelDto.destination())
                        .build())
        );

        Travel travel = Travel.builder()
                .title(registerTravelDto.title())
                .thumbnail(registerTravelDto.thumbnail())
                .user(user)
                .tags(tags)
                .destination(destination)
                .build();

        travelRepository.save(travel);

        return new RegisterTravelResDto(travel.getId());
    }

    @Cacheable("travelFeedLatest")
    public FeedDto getTravelFeed(String cursor) {
        List<Travel> travels = getTravelsByCursor(cursor);

        List<TravelDto> travelsDto = travels.stream().map(travel ->
                TravelDto.fromTravel(travel, false)).toList();

        return new FeedDto(travelsDto);
    }

    public List<TravelDto> getUserTravels(User user, Pageable pageable) {
        List<Travel> travels = travelRepository.findAllByUser(user, pageable).getContent();
        return travels.stream().map(travel -> TravelDto.fromTravel(travel, null)).toList();
    }

    public TravelDetailResDto getTravelDetails(User user, Long travelId) {
        boolean isLiked = false;

        List<LocationGroup> locationGroups = locationGroupRepository.findAllByTravelId(travelId);
        List<LocationGroupResDto> dtos =
                locationGroups.stream().map(locationGroup -> LocationGroupResDto.fromLocationGroup(locationGroup,
                locationGroup.getPictures().stream().map(PictureResDto::fromPicture).toList())).toList();

        if (user != null) {
            isLiked = likesRepository.existsByUserAndTravelId(user, travelId);
        }

        return new TravelDetailResDto(dtos, isLiked);
    }

    private List<Travel> getTravelsByCursor(String cursor) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));

        if (Objects.equals(cursor, CURSOR_LATEST)) {
            return travelRepository.findAll(pageable).getContent();
        }
        return travelRepository.findByIdLessThan(Long.parseLong(cursor), pageable).getContent();
    }
}
