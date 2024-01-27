package com.travellerybe.search.query.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travellerybe.user.command.domain.User;

import javax.annotation.Nullable;

public record AutoCompletionByUser(
        String name,
        String picture,
        String type
) {
    private static final String USER_TYPE = "user" ;
    public static AutoCompletionByUser fromUser(User user) {

        return new AutoCompletionByUser(user.getUsername(), user.getPicture(), USER_TYPE);
    }
}
