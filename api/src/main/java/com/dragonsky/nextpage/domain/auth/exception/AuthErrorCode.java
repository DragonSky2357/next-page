package com.dragonsky.nextpage.domain.auth.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {
    PASSWORD_NOT_MATCHED("AUTH_001", "비밀번호가 일치하지 않습니다.");

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
