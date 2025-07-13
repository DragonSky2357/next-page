package com.dragonsky.nextpage.domain.member.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND("MEMBER_001", "존재하지 않는 멤버입니다.", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_EXISTS("MEMBER_002", "이미 존재하는 이메일입니다.", HttpStatus.CONFLICT),
    NICKNAME_ALREADY_EXISTS("MEMBER_003", "이미 존재하는 닉네임입니다.", HttpStatus.CONFLICT),
    UNSUPPORTED_SEARCH_TYPE("MEMBER_004", "지원하지 않는 검색 타입입니다.", HttpStatus.BAD_REQUEST),
    MEMBER_ERROR("MEMBER_999", "오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    MemberErrorCode(String code, String message, HttpStatus httpStatus) {
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
