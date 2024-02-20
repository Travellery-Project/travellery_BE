package com.travellerybe.search.repository;

import com.travellerybe.search.command.domain.SearchHistory;
import com.travellerybe.user.command.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    Page<SearchHistory> findByUser(User user, Pageable pageable);

    List<SearchHistory> findByUserOrderByCreatedDateDesc(User user);

    List<SearchHistory> findAllByUser(User user);

    boolean existsByUserAndKeyword(User user, String keyword);
}
