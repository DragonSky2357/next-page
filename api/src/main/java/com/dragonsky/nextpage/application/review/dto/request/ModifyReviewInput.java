package com.dragonsky.nextpage.application.review.dto.request;

public record ModifyReviewInput(
        Long reviewId,
        Long userId,
        String title,
        String content,
        Integer rating,
        String searchKeywords,
        String status,
        String category,
        String tag,
        Boolean isPrivate
) {
}
