package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResponse;

public record ReviewDetailApiResponse(
        Long reviewId,
        String author,
        String title,
        String content,
        Integer rating,
        Integer statusCode,
        Integer categoryCode,
        Integer tagCode,
        Boolean isPrivate
) {
}
