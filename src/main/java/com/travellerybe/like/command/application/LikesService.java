package com.travellerybe.like.command.application;

import com.travellerybe.like.command.domain.Likes;
import com.travellerybe.like.query.repository.LikesRepository;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.command.dto.domain.mapper.TravelMapper;
import com.travellerybe.travel.command.dto.response.FeedResDto;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.travel.command.dto.domain.FeedDto;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.travellerybe.travel.exception.TravelExceptionType.NOT_FOUND_TRAVEL;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class LikesService {

    private final LikesRepository likesRepository;
    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;

    public Page<Likes> getLikes(User user, Pageable pageable) {
        return likesRepository.getAllByUser(user, pageable);
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
