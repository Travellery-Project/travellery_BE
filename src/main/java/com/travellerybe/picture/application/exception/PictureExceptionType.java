package com.travellerybe.picture.application.exception;

import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
public enum PictureExceptionType implements BaseExceptionType {

    S3_UPLOAD_FAILED(INTERNAL_SERVER_ERROR, "S3 스토리지 사진 업로드에 실패하였습니다.");


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
