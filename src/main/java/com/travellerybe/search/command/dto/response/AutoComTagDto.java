package com.travellerybe.search.command.dto.response;

import com.travellerybe.travel.command.domain.Tag;

public record AutoComTagDto(
        String name,
        String type
) {
    private static final String TAG_TYPE = "tag";
    public static AutoComTagDto fromTag(Tag tag){
        return new AutoComTagDto(tag.getName(), TAG_TYPE);

    }
}
