package com.dragonsky.nextpage.review.domain.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum ReviewErrorCode implements ErrorCode {
    REVIEW_NOT_FOUND("REVIEW_001", "존재하지 않는 리뷰입니다.", HttpStatus.NOT_FOUND),
    UNAUTHORIZED_REVIEW_ACCESS("REVIEW_002", "리뷰에 접근할 권한이 없습니다.", HttpStatus.FORBIDDEN),
    UNAUTHORIZED_REVIEW_REMOVE("REVIEW_003", "리뷰에 삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN),
    INVALID_REVIEW_CONTENT("REVIEW_004", "리뷰 내용이 유효하지 않습니다.", HttpStatus.BAD_REQUEST),
    REVIEW_ALREADY_DELETED("REVIEW_005", "이미 삭제된 리뷰입니다.", HttpStatus.NOT_FOUND),

    REVIEW_OPERATION_FAILED("REVIEW_999", "리뷰 처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ReviewErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
