package com.dragonsky.nextpage.member.domain.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class MemberException extends BusinessException {

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode);
    }
}