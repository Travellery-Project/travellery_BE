package com.travellerybe.common.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException() {
    }

    public abstract BaseExceptionType exceptionType();
}
