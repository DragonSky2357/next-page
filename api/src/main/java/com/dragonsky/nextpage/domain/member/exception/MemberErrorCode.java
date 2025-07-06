package com.dragonsky.nextpage.domain.member.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND("MEMBER_001", "존재하지 않은 멤버입니다."),
    EMAIL_ALREADY_EXISTS("MEMBER_002", "이미 존재하는 이메일입니다."),
    NICKNAME_ALREADY_EXISTS("MEMBER_002", "이미 존재하는 닉네임입니다.");

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
