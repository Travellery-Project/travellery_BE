package com.travellerybe.user.repository;

import com.travellerybe.user.command.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    List<User> findFirst10ByUsernameContaining(String keyword);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "travels")
    Optional<User> findById(Long id);

    boolean existsByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.picture = :picture WHERE u.id = :userId")
    void updatePicture(Long userId, String picture);

    @Modifying
    @Query("UPDATE User u SET u.description = :description, u.username = :username WHERE u.id = :userId")
    void updateUserProfile(Long userId, String description, String username);
}
