package com.dragonsky.nextpage.member.domain.exception;

import com.dragonsky.nextpage.exception.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND("MEMBER_001", "Member not found."),
    EMAIL_ALREADY_EXISTS("MEMBER_002", "Email already exists."),
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
