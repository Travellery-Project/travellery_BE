package com.travellerybe.search.application.service;

import com.travellerybe.search.application.dto.mapper.SearchHistoryMapper;
import com.travellerybe.search.application.dto.request.DeleteSearchHistoryReqDto;
import com.travellerybe.search.application.dto.response.*;
import com.travellerybe.search.application.exception.SearchException;
import com.travellerybe.search.domain.AutoCompletionType;
import com.travellerybe.search.domain.SearchHistory;
import com.travellerybe.search.repository.SearchHistoryRepository;
import com.travellerybe.travel.application.dto.domain.FeedDto;
import com.travellerybe.travel.application.dto.mapper.DestinationMapper;
import com.travellerybe.travel.application.dto.mapper.TagMapper;
import com.travellerybe.travel.application.dto.mapper.TravelMapper;
import com.travellerybe.travel.application.exception.TravelException;
import com.travellerybe.travel.domain.Destination;
import com.travellerybe.travel.domain.Tag;
import com.travellerybe.travel.domain.Travel;
import com.travellerybe.travel.repository.DestinationRepository;
import com.travellerybe.travel.repository.TagRepository;
import com.travellerybe.travel.repository.TravelRepository;
import com.travellerybe.user.application.dto.mapper.UserMapper;
import com.travellerybe.user.application.exception.AuthException;
import com.travellerybe.user.domain.User;
import com.travellerybe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.travellerybe.search.application.exception.SearchExceptionType.NOT_FOUND_SEARCH_HISTORY;
import static com.travellerybe.travel.application.exception.TravelExceptionType.NOT_FOUND_DESTINATION;
import static com.travellerybe.travel.application.exception.TravelExceptionType.NOT_FOUND_TAG;
import static com.travellerybe.user.application.exception.AuthExceptionType.NOT_FOUND_MEMBER;
import static com.travellerybe.user.application.exception.AuthExceptionType.UNAUTHORIZED_REQUEST;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class SearchService {

    LocalDateTime WEEK_AGO = LocalDateTime.now().minusWeeks(2);

    private final SearchHistoryRepository searchHistoryRepository;
    private final UserRepository userRepository;
    private final TagRepository tagsRepository;
    private final DestinationRepository destinationRepository;
    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;
    private final UserMapper userMapper;
    private final TagMapper tagMapper;
    private final DestinationMapper destinationMapper;
    private final SearchHistoryMapper searchHistoryMapper;

    public SearchHistoryResDto getSearchHistory(User user) {
        List<SearchHistory> searchHistories = searchHistoryRepository.findByUserOrderByCreatedDateDesc(user);
        return new SearchHistoryResDto(searchHistories.stream().map(searchHistoryMapper::toSearchHistoryDto).toList());
    }

    @Transactional
    public void deleteSearchHistoryOne(User user, DeleteSearchHistoryReqDto deleteSearchHistoryReqDto) {
        SearchHistory recentHistory = searchHistoryRepository.findById(deleteSearchHistoryReqDto.searchHistoryId())
                .orElseThrow(() -> new SearchException(NOT_FOUND_SEARCH_HISTORY));

        if (recentHistory.getUser() != user) throw new AuthException(UNAUTHORIZED_REQUEST);
        searchHistoryRepository.delete(recentHistory);
    }

    @Transactional
    public void deleteSearchHistoryAll(User user) {
        List<SearchHistory> searchHistories = searchHistoryRepository.findAllByUser(user);
        searchHistoryRepository.deleteAll(searchHistories);
    }

    @Cacheable("autoCompletion")
    public AutoCompletionResDto autoCompletion(String keyword) {
        List<User> users = userRepository.findFirst10ByUsernameContaining(keyword);
        List<Tag> tags = tagsRepository.findFirst10ByNameContaining(keyword);
        List<Destination> destinations = destinationRepository.findFirst10ByNameContaining(keyword);

        List<AutoComUserDto> autoComUsers = users.stream().map(
                user -> userMapper.toAutoComUserDto(user, AutoCompletionType.USER)).toList();
        List<AutoComTagDto> autoComTags = tags.stream().map(
                tag -> tagMapper.toAutoComTagDto(tag, AutoCompletionType.TAG)).toList();
        List<AutoComDestinationDto> autoComDestinations = destinations.stream().map(
                destination -> destinationMapper.AutoCompDestinationDto(destination, AutoCompletionType.DESTINATION)).toList();

        return new AutoCompletionResDto(autoComUsers, autoComTags, autoComDestinations);
    }

    @Transactional
    public SearchResDto searchByTraveler(User user, String travelerName, Pageable pageable) {
        saveHistory(user, travelerName);
        User traveler = userRepository.findByUsername(travelerName).orElseThrow(
                () -> new AuthException(NOT_FOUND_MEMBER));
        Page<Travel> travels = travelRepository.findAllByUser(traveler, pageable);

        List<FeedDto> travelRes = travels.stream().map(travelMapper::toFeedDto).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto searchByTag(User user, String tagName, Pageable pageable) {
        saveHistory(user, tagName);
        Tag tag = tagsRepository.findByName(tagName).orElseThrow(
                () -> new TravelException(NOT_FOUND_TAG));
        Page<Travel> travels = travelRepository.findAllByTagsContaining(tag, pageable);

        List<FeedDto> travelRes = travels.stream().map(travelMapper::toFeedDto).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto searchByDestination(User user, String destinationName, Pageable pageable) {
        saveHistory(user, destinationName);
        Destination destination = destinationRepository.findByName(destinationName).orElseThrow(
                () -> new TravelException(NOT_FOUND_DESTINATION));
        Page<Travel> travels = travelRepository.findAllByDestination(destination, pageable);

        List<FeedDto> travelRes = travels.stream().map(travelMapper::toFeedDto).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto search(User user, String keyword, Pageable pageable) {
        saveHistory(user, keyword);
        Page<Travel> travels = travelRepository.findAllByKeyword(keyword, pageable);
        List<FeedDto> travelRes = travels.stream().map(travelMapper::toFeedDto).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    public PopularTravelerResDto getPopularTraveler() {
        Pageable pageable = PageRequest.of(0, 5);
        List<User> userRank = travelRepository.findUserRankings(WEEK_AGO, pageable);

        return new PopularTravelerResDto(userRank.stream().map(userMapper::toPopularTravelerDto).toList());
    }

    public PopularDestinationResDto getPopularDestination() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Destination> destinations = travelRepository.findDestinationRankings(WEEK_AGO, pageable);

        return new PopularDestinationResDto(destinations.stream().map(destinationMapper::toPopularDestinationDto).toList());
    }

    private void saveHistory(User user, String keyword) {
        if (user == null) return;

        if (!searchHistoryRepository.existsByUserAndKeyword(user, keyword)) {
            searchHistoryRepository.save(SearchHistory.builder()
                    .keyword(keyword)
                    .user(user)
                    .build());
        }
    }

}
