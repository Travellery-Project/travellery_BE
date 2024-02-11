package com.travellerybe.picture.exception;

import com.travellerybe.common.exception.BaseException;
import com.travellerybe.common.exception.BaseExceptionType;
import com.travellerybe.travel.exception.TravelExceptionType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PictureException extends BaseException {

    private final PictureExceptionType exceptionType;

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
