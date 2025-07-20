package com.dragonsky.nextpage.application.review.dto.response;

public record GetReviewResponse(
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
