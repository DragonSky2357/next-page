package com.dragonsky.nextpage.domain.member.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class MemberException extends BusinessException {

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode);
    }
}