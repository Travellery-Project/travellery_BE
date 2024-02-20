package com.travellerybe.search.presentation;

import com.travellerybe.search.command.application.SearchService;
import com.travellerybe.search.command.dto.response.SearchResDto;
import com.travellerybe.search.command.dto.request.DeleteSearchHistoryReqDto;
import com.travellerybe.search.command.dto.response.*;
import com.travellerybe.user.command.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/history")
    public ResponseEntity<SearchHistoryResDto> getSearchHistory(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(searchService.getSearchHistory(user));
    }

    @PostMapping("/history/delete/one")
    public ResponseEntity<String> deleteSearchHistoryOne(@AuthenticationPrincipal User user,
                                                         @RequestBody DeleteSearchHistoryReqDto deleteSearchHistoryReqDto) {
        searchService.deleteSearchHistoryOne(user, deleteSearchHistoryReqDto);
        return ResponseEntity.ok().body("성공적으로 삭제했습니다.");
    }

    @PostMapping("/history/delete/all")
    public ResponseEntity<String> deleteSearchHistoryAll(@AuthenticationPrincipal User user) {
        searchService.deleteSearchHistoryAll(user);
        return ResponseEntity.ok().body("성공적으로 삭제했습니다.");
    }

    @GetMapping("/auto-complete")
    public ResponseEntity<AutoCompletionResDto> autoCompletion(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok().body(searchService.autoCompletion(keyword));
    }

    @GetMapping("/user")
    public ResponseEntity<SearchResDto> searchByTraveler(@AuthenticationPrincipal User user,
                                                         @RequestParam("keyword") String travelerName,
                                                         @SortDefault(sort = "createdDate", direction =
                                                                 Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(searchService.searchByTraveler(user, travelerName, pageable));
    }

    @GetMapping("/tag")
    public ResponseEntity<SearchResDto> searchByTag(@AuthenticationPrincipal User user,
                                                    @RequestParam("keyword") String tagName,
                                                    @SortDefault(sort = "createdDate", direction =
                                                            Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(searchService.searchByTag(user, tagName, pageable));
    }

    @GetMapping("/destination")
    public ResponseEntity<SearchResDto> searchByDestination(@AuthenticationPrincipal User user,
                                                            @RequestParam("keyword") String destination,
                                                            @SortDefault(sort = "createdDate", direction =
                                                                    Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(searchService.searchByDestination(user, destination, pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<SearchResDto> search(@AuthenticationPrincipal User user,
                                               @RequestParam("keyword") String keyword,
                                               @SortDefault(sort = "createdDate", direction =
                                                       Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(searchService.search(user, keyword, pageable));
    }

    @GetMapping("/traveler/popular")
    public ResponseEntity<PopularTravelerResDto> getPopularTraveler() {
        return ResponseEntity.ok().body(searchService.getPopularTraveler());
    }

    @GetMapping("/destination/popular")
    public ResponseEntity<PopularDestinationResDto> getPopularDestination() {
        return ResponseEntity.ok().body(searchService.getPopularDestination());
    }
}
