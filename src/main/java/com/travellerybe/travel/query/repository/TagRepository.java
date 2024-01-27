package com.travellerybe.travel.query.repository;

import com.travellerybe.travel.command.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);
    List<Tag> findFirst10ByNameContaining(String name);
}
