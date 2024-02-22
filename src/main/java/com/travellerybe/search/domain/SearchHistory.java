package com.travellerybe.search.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.travellerybe.common.domain.BaseEntity;
import com.travellerybe.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "search_history")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchHistory extends BaseEntity {

    @JsonInclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String keyword;

}
