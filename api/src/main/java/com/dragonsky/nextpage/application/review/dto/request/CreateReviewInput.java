package com.dragonsky.nextpage.application.review.dto.request;

public record CreateReviewInput(
        Long authorId,
        String title,
        String content,
        Integer rating,
        Integer statusCode,
        Integer categoryCode,
        Integer tagCode,
        String searchKeywords,
        Boolean isPrivate
) {
}
