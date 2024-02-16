package com.travellerybe.like.query.repository;

import com.travellerybe.user.command.domain.User;
import com.travellerybe.like.command.domain.Likes;
import com.travellerybe.travel.command.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Page<Likes> getAllByUser(User user, Pageable pageable);
    void deleteByUserAndTravelId(User user, Long travelId);
    boolean existsByUserAndTravelId(User user, Long travelId);

}
