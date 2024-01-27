package com.travellerybe.like.exception;

import com.travellerybe.common.exception.BaseException;
import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LikesException extends BaseException {

    private final LikesExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
