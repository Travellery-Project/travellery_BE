package com.travellerybe.travel.command.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travellerybe.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Destination extends BaseEntity {

    private String name;

    private String picture;

    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
    @Builder.Default
    @JsonManagedReference
    private List<Travel> travels = new ArrayList<>();

}
