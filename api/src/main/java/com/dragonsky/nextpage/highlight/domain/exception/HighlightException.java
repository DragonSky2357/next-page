package com.dragonsky.nextpage.highlight.domain.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class HighlightException extends BusinessException {

    public HighlightException(HighlightErrorCode errorCode) {
        super(errorCode);
    }
}