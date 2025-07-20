package com.dragonsky.nextpage.domain.review.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class ReviewException extends BusinessException {

    public ReviewException(ReviewErrorCode errorCode) {
        super(errorCode);
    }
}