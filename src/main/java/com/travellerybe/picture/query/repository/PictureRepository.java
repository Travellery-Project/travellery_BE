package com.travellerybe.picture.query.repository;

import com.travellerybe.user.command.domain.User;
import com.travellerybe.picture.command.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    int countByUser(User user);
    Page<Picture> findAllByUser (User user, Pageable pageable);
}
