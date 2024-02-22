package com.travellerybe.travel.application.dto.mapper;

import com.travellerybe.travel.application.dto.domain.FeedDto;
import com.travellerybe.travel.domain.Destination;
import com.travellerybe.travel.domain.Tag;
import com.travellerybe.travel.domain.Travel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TravelMapper {
    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTags")
    @Mapping(target = "destination", source = "destination", qualifiedByName = "mapDestination")
    @Mapping(target = "username", source = "travel.user.username")
    @Mapping(target = "userPicture", source = "travel.user.picture")
    FeedDto toFeedDto(Travel travel);

    @Named("mapTags")
    default List<String> mapTags(Set<Tag> tags) {
        return tags.stream().map(Tag::getName).toList();
    }

    @Named("mapDestination")
    default String mapDestination(Destination destination) {
        return destination.getName();
    }
}
