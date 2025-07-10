package com.dragonsky.nextpage.domain.auth.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class AuthException extends BusinessException {
    public AuthException(AuthErrorCode errorCode) {
        super(errorCode);
    }
}