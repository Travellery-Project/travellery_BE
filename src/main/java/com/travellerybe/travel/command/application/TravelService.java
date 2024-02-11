package com.travellerybe.travel.command.application;

import com.travellerybe.like.query.repository.LikesRepository;
import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.domain.LocationGroup;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.RegisterTravelResDto;
import com.travellerybe.travel.query.dto.response.TravelResDto;
import com.travellerybe.travel.query.repository.DestinationRepository;
import com.travellerybe.travel.query.repository.LocationGroupRepository;
import com.travellerybe.travel.query.repository.TagRepository;
import com.travellerybe.travel.query.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TravelService {
    private final LikesRepository likesRepository;

    private final DestinationRepository destinationRepository;
    private final TagRepository tagsRepository;
    private final LocationGroupRepository locationGroupRepository;
    private final TravelRepository travelRepository;

    @Transactional
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
    public List<TravelResDto> getTravelFeed(Pageable pageable, User user) {
        long startTime = System.currentTimeMillis();
        Page<Travel> travels = travelRepository.findAll(pageable);

        if (user == null) {
            List<TravelResDto> travelsDto =  travels.stream().map(travel ->
                    TravelResDto.fromTravel(travel, false)).toList();
            long endTime = System.currentTimeMillis();
            log.info("query execute time : {} ms", endTime - startTime);
            return travelsDto;
        }

        return travels.stream().map(travel ->
                TravelResDto.fromTravel(travel, likesRepository.existsByUserAndTravel(user, travel))).toList();

    }

    public List<TravelResDto> getUserTravels(User user, Pageable pageable) {
        List<Travel> travels = travelRepository.findAllByUser(user, pageable).getContent();
        return travels.stream().map(travel -> TravelResDto.fromTravel(travel, null)).toList();
    }

    public List<LocationGroup> getTravelDetails(Long travelId) {
        return locationGroupRepository.findAllByTravelId(travelId);
    }
}
