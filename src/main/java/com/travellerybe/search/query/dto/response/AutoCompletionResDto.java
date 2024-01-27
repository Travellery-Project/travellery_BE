package com.travellerybe.search.query.dto.response;

import java.util.List;

public record AutoCompletionResDto(
        List<AutoCompletionByUser> users,
        List<AutoCompletionByTag> tags,
        List<AutoCompletionByDestination> destinations
) {
}
