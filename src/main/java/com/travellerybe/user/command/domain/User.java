package com.travellerybe.user.command.domain;

import com.travellerybe.common.auth.domain.Authority;
import com.travellerybe.travel.command.domain.Travel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    private Set<Authority> authorities;

    private String email;

    private String password;

    @Column(unique = true)
    private String username;

    private String picture;

    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Travel> travels = new ArrayList<>();

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public void initializeTravels() {
        this.travels = new ArrayList<>();
    }
}

