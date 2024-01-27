package com.travellerybe.travel.exception;

import com.travellerybe.common.exception.BaseException;
import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TravelException extends BaseException {

    private final TravelExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
