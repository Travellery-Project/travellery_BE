package com.travellerybe.user.command.dto.domain.mapper;

import com.travellerybe.search.command.domain.AutoCompletionType;
import com.travellerybe.search.command.dto.response.AutoComUserDto;
import com.travellerybe.search.command.dto.response.PopularTravelerDto;
import com.travellerybe.user.command.domain.User;
import com.travellerybe.user.command.dto.domain.ProfileDto;
import com.travellerybe.user.command.dto.domain.UserDto;
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
