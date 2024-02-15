package com.travellerybe.travel.command.application;

import com.travellerybe.travel.query.dto.request.RegisterTravelDto;
import com.travellerybe.travel.query.dto.response.RegisterTravelResDto;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.query.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class TravelServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TravelService travelService;

    @Test
    @DisplayName("travel feed test")
    void insertBulkTravelTest() {
        RegisterTravelDto registerTravelDto = RegisterTravelDto.builder()
                .thumbnail("https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/9f06fe63-7a75-4058-8587-2c29f736e1b1")
                .title("Title_test_eviction")
                .destination("Destination")
                .tags(Set.of("Tag_5", "Tag2_6", "Tag3_5"))
                .build();

        User user = userRepository.findById(1L).orElseThrow();

        RegisterTravelResDto result = travelService.registerTravel(registerTravelDto, user);
    }

}
