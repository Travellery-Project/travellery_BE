package com.travellerybe.like.repository;

import com.travellerybe.user.domain.User;
import com.travellerybe.like.domain.Likes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {


    @EntityGraph(attributePaths = {"travel"})
    Page<Likes> getAllByUser(User user, Pageable pageable);
    void deleteByUserAndTravelId(User user, Long travelId);
    boolean existsByUserAndTravelId(User user, Long travelId);

}
