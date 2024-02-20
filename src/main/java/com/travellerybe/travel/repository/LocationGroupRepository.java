package com.travellerybe.travel.repository;

import com.travellerybe.travel.command.domain.LocationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationGroupRepository extends JpaRepository<LocationGroup, Long> {

    List<LocationGroup> findAllByTravelId(Long travelId);
}

