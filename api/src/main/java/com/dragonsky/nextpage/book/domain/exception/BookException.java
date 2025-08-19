package com.dragonsky.nextpage.book.domain.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class BookException extends BusinessException {

    public BookException(BookErrorCode errorCode) {
        super(errorCode);
    }
}