package com.travellerybe.user.application.exception;

import com.travellerybe.common.exception.BaseException;
import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthException extends BaseException {

    private final AuthExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}

