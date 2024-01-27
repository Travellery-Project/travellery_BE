package com.travellerybe.search.exception;

import com.travellerybe.common.exception.BaseException;
import com.travellerybe.common.exception.BaseExceptionType;
import com.travellerybe.like.exception.LikesExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchException extends BaseException {

    private final SearchExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}

