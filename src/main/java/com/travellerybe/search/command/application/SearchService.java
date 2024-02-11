package com.travellerybe.search.command.application;

import com.travellerybe.search.command.domain.SearchHistory;
import com.travellerybe.search.exception.SearchException;
import com.travellerybe.search.query.dto.request.DeleteSearchHistoryReqDto;
import com.travellerybe.search.query.dto.response.*;
import com.travellerybe.search.query.repository.SearchHistoryRepository;
import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.travel.command.domain.Travel;
import com.travellerybe.travel.exception.TravelException;
import com.travellerybe.travel.query.dto.response.TravelDto;
import com.travellerybe.travel.query.repository.DestinationRepository;
import com.travellerybe.travel.query.repository.TagRepository;
import com.travellerybe.travel.query.repository.TravelRepository;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.exception.AuthException;
import com.travellerybe.user.query.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.travellerybe.search.exception.SearchExceptionType.NOT_FOUND_SEARCH_HISTORY;
import static com.travellerybe.travel.exception.TravelExceptionType.NOT_FOUND_DESTINATION;
import static com.travellerybe.travel.exception.TravelExceptionType.NOT_FOUND_TAG;
import static com.travellerybe.user.exception.AuthExceptionType.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class SearchService {

    private final int SEARCH_HISTORY_SIZE = 10;
    private final int SEARCH_HISTORY_NUMBER = 0;
    LocalDateTime WEEK_AGO = LocalDateTime.now().minusWeeks(2);

    private final SearchHistoryRepository searchHistoryRepository;
    private final UserRepository userRepository;
    private final TagRepository tagsRepository;
    private final DestinationRepository destinationRepository;
    private final TravelRepository travelRepository;

    public List<SearchHistoryResDto> getSearchHistory(User user) {
        ;
        List<SearchHistory> searchHistories = searchHistoryRepository.findByUserOrderByCreatedDateDesc(user);
        return searchHistories.stream().map(searchHistory -> new SearchHistoryResDto(searchHistory.getId(),
                searchHistory.getKeyword())).toList();
    }

    @Transactional
    public void deleteSearchHistoryOne(User user, DeleteSearchHistoryReqDto deleteSearchHistoryReqDto) {
        SearchHistory recentHistory = searchHistoryRepository.findById(deleteSearchHistoryReqDto.searchHistoryId())
                .orElseThrow(() -> new SearchException(NOT_FOUND_SEARCH_HISTORY));
//        if (recentHistory.getUser() != user) throw new SearchException(NO_AUTHORITY);
        searchHistoryRepository.delete(recentHistory);
    }

    @Transactional
    public void deleteSearchHistoryAll(User user) {
        List<SearchHistory> searchHistories = searchHistoryRepository.findAllByUser(user);
        searchHistoryRepository.deleteAll(searchHistories);
    }

    public AutoCompletionResDto autoCompletion(String keyword) {
        List<User> userList = userRepository.findFirst10ByUsernameContaining(keyword);
        List<Tag> tagList = tagsRepository.findFirst10ByNameContaining(keyword);
        List<Destination> destinationList = destinationRepository.findFirst10ByNameContaining(keyword);

        List<AutoCompletionByUser> users = userList.stream().map(AutoCompletionByUser::fromUser).toList();
        List<AutoCompletionByTag> tags = tagList.stream().map(AutoCompletionByTag::fromTag).toList();
        List<AutoCompletionByDestination> destinations = destinationList.stream()
                .map(AutoCompletionByDestination::fromDestination).toList();

        return new AutoCompletionResDto(users, tags, destinations);
    }

    @Transactional
    public SearchResDto searchByTraveler(User user, String travelerName, Pageable pageable) {
        saveHistory(user, travelerName);
        User traveler = userRepository.findByUsername(travelerName).orElseThrow(
                () -> new AuthException(NOT_FOUND_MEMBER));
        Page<Travel> travels = travelRepository.findAllByUser(traveler, pageable);

        List<TravelDto> travelRes = travels.stream().map(travel -> TravelDto.fromTravel(travel, null)).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto searchByTag(User user, String tagName, Pageable pageable) {
        saveHistory(user, tagName);
        Tag tag = tagsRepository.findByName(tagName).orElseThrow(
                () -> new TravelException(NOT_FOUND_TAG));
        Page<Travel> travels = travelRepository.findAllByTagsContaining(tag, pageable);

        List<TravelDto> travelRes = travels.stream().map(travel -> TravelDto.fromTravel(travel, null)).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto searchByDestination(User user, String destinationName, Pageable pageable) {
        saveHistory(user, destinationName);
        Destination destination = destinationRepository.findByName(destinationName).orElseThrow(
                () -> new TravelException(NOT_FOUND_DESTINATION));
        Page<Travel> travels = travelRepository.findAllByDestination(destination, pageable);

        List<TravelDto> travelRes = travels.stream().map(travel -> TravelDto.fromTravel(travel, null)).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    @Transactional
    public SearchResDto search(User user, String keyword, Pageable pageable) {
        saveHistory(user, keyword);
        Page<Travel> travels = travelRepository.findAllByKeyword(keyword, pageable);
        List<TravelDto> travelRes = travels.stream().map(travel -> TravelDto.fromTravel(travel, null)).toList();
        return new SearchResDto(travelRes, travels.getTotalElements());
    }

    public List<PopularTravelerResDto> getPopularTraveler() {
        Pageable pageable = PageRequest.of(0, 5);
        List<User> userRank = travelRepository.findUserRankings(WEEK_AGO, pageable);

        return userRank.stream().map(user -> new PopularTravelerResDto(user.getUsername(), user.getPicture())).toList();
    }

    public List<PopularDestinationResDto> getPopularDestination() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Destination> destinations = travelRepository.findDestinationRankings(WEEK_AGO, pageable);

        return destinations.stream().map(destination -> new PopularDestinationResDto(destination.getName(),
                destination.getPicture())).toList();
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
