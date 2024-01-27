package com.travellerybe.travel.query.repository;

import com.travellerybe.travel.command.domain.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    Optional<Destination> findByName(String name);

    List<Destination> findFirst10ByNameContaining(String name);
}
