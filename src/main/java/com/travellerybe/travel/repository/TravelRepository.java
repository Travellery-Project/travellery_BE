package com.travellerybe.travel.repository;

import com.travellerybe.travel.command.domain.Destination;
import com.travellerybe.travel.command.domain.Tag;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.travel.command.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @EntityGraph(attributePaths = {"destination", "user"})
    Page<Travel> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"destination", "user"})
    Slice<Travel> findByIdLessThan(Long id, Pageable pageable);

    @Query("SELECT t.id FROM Travel t ORDER BY t.id DESC LIMIT 1")
    Long findFirst();

    Page<Travel> findAllByUser(User user, Pageable pageable);

    Page<Travel> findAllByTagsContaining(Tag tag, Pageable pageable);

    Page<Travel> findAllByDestination(Destination destination, Pageable pageable);

    @Query("SELECT DISTINCT t FROM Travel t " +
            "LEFT JOIN t.destination d " +
            "LEFT JOIN t.tags tg " +
            "JOIN t.user u " +
            "WHERE d.name LIKE %:keyword% OR tg.name LIKE %:keyword% OR u.username LIKE %:keyword%")
    Page<Travel> findAllByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT l.traveler, COUNT(l.traveler) AS travelerCount " +
            "FROM Likes l " +
            "WHERE l.createdDate >= :weekAgo " +
            "GROUP BY l.traveler " +
            "ORDER BY travelerCount DESC")
    List<User> findUserRankings(@Param("weekAgo") LocalDateTime weekAgo, Pageable pageable);

    @Query("SELECT t.destination, COUNT(t.destination) AS destinationCount " +
            "FROM Travel t " +
            "WHERE t.createdDate >= :weekAgo " +
            "GROUP BY t.destination " +
            "ORDER BY destinationCount DESC")
    List<Destination> findDestinationRankings(@Param("weekAgo") LocalDateTime weekAgo, Pageable pageable);

    int countByUser(User user);
}
