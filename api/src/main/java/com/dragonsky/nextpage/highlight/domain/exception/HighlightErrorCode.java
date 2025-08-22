package com.dragonsky.nextpage.highlight.domain.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum HighlightErrorCode implements ErrorCode {
    HIGHLIGHT_NOT_FOUND("HIGHLIGHT_001", "존재하지 않는 하이라이트입니다.", HttpStatus.NOT_FOUND),
    UNAUTHORIZED_HIGHLIGHT_ACCESS("HIGHLIGHT_002", "하이라이트에 접근할 권한이 없습니다.", HttpStatus.FORBIDDEN),
    UNAUTHORIZED_HIGHLIGHT_REMOVE("HIGHLIGHT_003", "하이라이트 삭제 권한이 없습니다.", HttpStatus.FORBIDDEN),
    INVALID_HIGHLIGHT_CONTENT("HIGHLIGHT_004", "하이라이트 내용이 유효하지 않습니다.", HttpStatus.BAD_REQUEST),
    HIGHLIGHT_ALREADY_DELETED("HIGHLIGHT_005", "이미 삭제된 하이라이트입니다.", HttpStatus.NOT_FOUND),

    HIGHLIGHT_OPERATION_FAILED("HIGHLIGHT_999", "하이라이트 처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    HighlightErrorCode(String code, String message, HttpStatus httpStatus) {
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
