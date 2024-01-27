package com.travellerybe.user.query.repository;

import com.travellerybe.user.command.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findByUsername(String username);

    List<User> findFirst10ByUsernameContaining(String keyword);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "travels")
    Optional<User> findById(Long id);

    boolean existsByUsername(String username);

}