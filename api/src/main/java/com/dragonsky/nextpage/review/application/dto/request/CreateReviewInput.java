package com.dragonsky.nextpage.review.application.dto.request;

public record CreateReviewInput(
        Long authorId,
        String title,
        String content,
        Integer rating,
        String status,
        String category,
        String tag,
        String searchKeywords,
        Boolean isPrivate,
        String isbn
) {
}
