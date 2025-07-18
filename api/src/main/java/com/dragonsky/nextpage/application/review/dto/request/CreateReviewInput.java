package com.dragonsky.nextpage.application.review.dto.request;

public record CreateReviewInput(
    Long authorId,
    String title,
    String content,
    Integer rating,
    Long statusCode,
    Long categoryCode,
    Long tagCode,
    String searchKeywords,
    Boolean isPrivate
) {
}
