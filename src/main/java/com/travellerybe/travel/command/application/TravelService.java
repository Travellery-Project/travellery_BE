package com.travellerybe.travel.command.application;

import com.travellerybe.like.query.repository.LikesRepository;
import com.travellerybe.picture.command.dto.domain.mapper.PictureMapper;
import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.command.dto.domain.FeedDto;
import com.travellerybe.travel.command.dto.domain.TravelDetailDto;
import com.travellerybe.travel.command.dto.domain.mapper.LocationGroupMapper;
import com.travellerybe.travel.command.dto.domain.mapper.TravelMapper;
import com.travellerybe.travel.command.dto.request.RegisterTravelDto;
import com.travellerybe.travel.command.dto.response.FeedResDto;
import com.travellerybe.travel.command.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.command.dto.response.TravelDetailResDto;
import com.travellerybe.travel.repository.DestinationRepository;
import com.travellerybe.travel.repository.LocationGroupRepository;
import com.travellerybe.travel.repository.TagRepository;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private final TravelMapper travelMapper;
    private final LocationGroupMapper locationGroupMapper;
    private final PictureMapper pictureMapper;

    @Transactional
    @CacheEvict(value = "travelFeedLatest", key = "'latest'")
    public RegisterTravelResDto registerTravel(RegisterTravelDto registerTravelDto, User user) {

        Set<Tag> tags = registerTravelDto.tags().stream().map(tagName ->
                tagsRepository.findByName(tagName).orElseGet(() ->
                        tagsRepository.save(Tag.builder().name(tagName).build())
                )
        ).collect(Collectors.toSet());

        Optional<Destination> existingDestination = destinationRepository.findByName(registerTravelDto.destination());

        Destination destination = existingDestination.orElseGet(() ->
                destinationRepository.save(Destination.builder().name(registerTravelDto.destination()).build())
        );

        Travel travel = travelRepository.save(Travel.builder()
                .title(registerTravelDto.title())
                .thumbnail(registerTravelDto.thumbnail())
                .user(user)
                .tags(tags)
                .destination(destination)
                .build());

        return new RegisterTravelResDto(travel.getId());
    }

    @Cacheable("travelFeedLatest")
    public FeedResDto getTravelFeed(String cursor) {
        log.info(cursor);
        List<Travel> travels = getTravelsByCursor(cursor);
        List<FeedDto> travelsDto = travels.stream().map(travelMapper::toFeedDto).toList();

        return new FeedResDto(travelsDto);
    }

    public List<FeedDto> getUserTravels(User user, Pageable pageable) {
        List<Travel> travels = travelRepository.findAllByUser(user, pageable).getContent();
        return travels.stream().map(travelMapper::toFeedDto).toList();
    }

    public TravelDetailResDto getTravelDetails(User user, Long travelId) {
        boolean isLiked = false;

        List<LocationGroup> locationGroups = locationGroupRepository.findAllByTravelId(travelId);

        List<TravelDetailDto> travelDetailDtos =
                locationGroups.stream().map(locationGroup -> locationGroupMapper.toTravelDetailDto(locationGroup,
                        locationGroup.getPictures().stream().map(pictureMapper::toPictureDto).toList())).toList();

        if (user != null) {
            isLiked = likesRepository.existsByUserAndTravelId(user, travelId);
        }

        return new TravelDetailResDto(travelDetailDtos, isLiked);
    }

    private List<Travel> getTravelsByCursor(String cursor) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));

        if (Objects.equals(cursor, CURSOR_LATEST)) {
            return travelRepository.findAll(pageable).getContent();
        }
        return travelRepository.findByIdLessThan(Long.parseLong(cursor), pageable).getContent();
    }
}
