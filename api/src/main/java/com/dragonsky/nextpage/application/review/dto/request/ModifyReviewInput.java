package com.dragonsky.nextpage.application.review.dto.request;

public record ModifyReviewInput(
        Long reviewId,
        Long userId,
        String title,
        String content,
        Integer rating,
        String searchKeywords,
        Integer statusCode,
        Integer categoryCode,
        Integer tagCode,
        Boolean isPrivate
) {
}
