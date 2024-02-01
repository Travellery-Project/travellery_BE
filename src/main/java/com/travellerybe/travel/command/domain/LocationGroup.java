package com.travellerybe.travel.command.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travellerybe.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"Travel"})
public class LocationGroup extends BaseEntity {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "locationGroup", cascade = CascadeType.ALL)
    private List<Picture> pictures = new ArrayList<>();

    private String description;
    private String address;
    private String location;
    private Date startDate;
    private Date endDate;
    private Double latitude;
    private Double longitude;
    private String specificLocation;
    private String specificAddress;

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
