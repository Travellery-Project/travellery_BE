package com.travellerybe.like.application.service;

import com.travellerybe.like.domain.Likes;
import com.travellerybe.like.repository.LikesRepository;
import com.travellerybe.travel.domain.Travel;
import com.travellerybe.travel.application.dto.mapper.TravelMapper;
import com.travellerybe.travel.application.dto.response.FeedResDto;
import com.travellerybe.travel.application.exception.TravelException;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.travellerybe.travel.application.exception.TravelExceptionType.NOT_FOUND_TRAVEL;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class LikesService {

    private final LikesRepository likesRepository;
    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;

    public FeedResDto getLikes(User user, Pageable pageable) {
        Page<Likes> likes = likesRepository.getAllByUser(user, pageable);
        return new FeedResDto(likes.getContent().stream().map(like -> travelMapper.toFeedDto(like.getTravel())).toList());
    }

    @Transactional
    public void addLikes(User user, Long travelId) {
        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new TravelException(NOT_FOUND_TRAVEL));

        likesRepository.save(Likes.builder()
                .travel(travel)
                .user(user)
                .traveler(travel.getUser())
                .build());
    }

    @Transactional
    public void deleteLikes(User user, Long travelId) {
        likesRepository.deleteByUserAndTravelId(user, travelId);
    }

    public FeedResDto getUserLikedTravel(User user, Pageable pageable) {
        List<Likes> likesList = likesRepository.getAllByUser(user, pageable).getContent();

        return new FeedResDto(likesList.stream().map(likes -> travelMapper.toFeedDto(likes.getTravel())).toList());
    }
}
