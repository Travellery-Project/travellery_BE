package com.travellerybe.travel.exception;

import com.travellerybe.common.exception.BaseExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RequiredArgsConstructor
public enum TravelExceptionType implements BaseExceptionType {

    S3_UPLOAD_FAILED(INTERNAL_SERVER_ERROR, "S3 스토리지 사진 업로드에 실패하였습니다."),
    NOT_FOUND_TRAVEL(BAD_REQUEST, "잘못된 Travel 정보 입니다."),
    NO_MORE_CONTENTS(BAD_REQUEST, "더 이상 가져올 Travel 정보가 없습니다."),
    NOT_FOUND_TAG(BAD_REQUEST, "Tag 정보를 찾을 수 없습니다."),
    NOT_FOUND_DESTINATION(BAD_REQUEST, "여행지 정보를 찾을 수 없습니다.")
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
