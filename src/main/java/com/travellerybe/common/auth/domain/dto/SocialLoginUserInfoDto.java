package com.travellerybe.common.auth.domain.dto;

import lombok.Builder;

@Builder
public record SocialLoginUserInfoDto(
        String name,
        String email,
        String picture
){}
