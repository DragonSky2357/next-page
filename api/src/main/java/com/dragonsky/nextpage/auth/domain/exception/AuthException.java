package com.dragonsky.nextpage.auth.domain.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class AuthException extends BusinessException {
    public AuthException(AuthErrorCode errorCode) {
        super(errorCode);
    }
}