package com.travellerybe.search.exception;

import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
public enum SearchExceptionType implements BaseExceptionType {
    NOT_FOUND_SEARCH_HISTORY(BAD_REQUEST, "검색 기록을 찾을 수 없습니다."),
    NO_AUTHORITY(BAD_REQUEST, "권한이 없습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String errorMessage;

    @Override
    public HttpStatus httpStatus() {
        return null;
    }

    @Override
    public String errorMessage() {
        return null;
    }
}
