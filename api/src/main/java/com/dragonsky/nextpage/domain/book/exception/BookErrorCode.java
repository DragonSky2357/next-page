package com.dragonsky.nextpage.domain.book.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum BookErrorCode implements ErrorCode {
    BOOK_NOT_FOUND("BOOK_001", "도서 정보를 가져오는데 실패하였습니다. 다시 시도해주세요.", HttpStatus.NOT_FOUND),

    REVIEW_OPERATION_FAILED("BOOK_999", "도서 정보 처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    BookErrorCode(String code, String message, HttpStatus httpStatus) {
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
