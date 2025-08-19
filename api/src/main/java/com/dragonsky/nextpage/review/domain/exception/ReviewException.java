package com.dragonsky.nextpage.review.domain.exception;

import com.dragonsky.nextpage.exception.BusinessException;

public class ReviewException extends BusinessException {

    public ReviewException(ReviewErrorCode errorCode) {
        super(errorCode);
    }
}