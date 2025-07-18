package com.dragonsky.nextpage.application.review.dto.request;

import lombok.Builder;

@Builder
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
