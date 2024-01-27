package com.travellerybe.search.query.dto.response;

import com.travellerybe.travel.command.domain.Tag;

public record AutoCompletionByTag(
        String name,
        String type
) {
    private static final String TAG_TYPE = "tag";
    public static AutoCompletionByTag fromTag(Tag tag){
        return new AutoCompletionByTag(tag.getName(), TAG_TYPE);

    }
}
