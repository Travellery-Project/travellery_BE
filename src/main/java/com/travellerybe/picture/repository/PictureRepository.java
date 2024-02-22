package com.travellerybe.picture.repository;

import com.travellerybe.user.domain.User;
import com.travellerybe.picture.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    int countByUser(User user);
    Page<Picture> findAllByUser (User user, Pageable pageable);
}
