package com.travellerybe.user.application.exception;

import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
public enum AuthExceptionType implements BaseExceptionType {

    UNSUPPORTED_OAUTH_TYPE(BAD_REQUEST, "지원하지 않는 소셜 로그인 타입입니다."),
    NOT_FOUND_MEMBER(NOT_FOUND, "회원을 찾을 수 없습니다"),
    UNAUTHORIZED_REQUEST(UNAUTHORIZED, "인증되지 않았습니다"),
    REQUEST_EMPTY(BAD_REQUEST, "요청은 널일 수 없습니다"),
    DUPLICATED_USERNAME(BAD_REQUEST, "중복된 사용자 이름입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String errorMessage;

    @Override
    public HttpStatus httpStatus() {
        return httpStatus;
    }

    @Override
    public String errorMessage() {
        return errorMessage;
    }
}

