package com.travellerybe.user.application.dto.mapper;

import com.travellerybe.search.domain.AutoCompletionType;
import com.travellerybe.search.application.dto.response.AutoComUserDto;
import com.travellerybe.search.application.dto.response.PopularTravelerDto;
import com.travellerybe.user.application.dto.domain.ProfileDto;
import com.travellerybe.user.application.dto.domain.UserDto;
import com.travellerybe.user.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    ProfileDto toProfileDto(User user, int travelCount, int pictureCount);

    PopularTravelerDto toPopularTravelerDto(User user);

    @Mapping(source = "user.username", target = "name")
    AutoComUserDto toAutoComUserDto(User user, AutoCompletionType type);
}
