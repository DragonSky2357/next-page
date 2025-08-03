package com.dragonsky.nextpage.application.review.dto.request;

public record RemoveReviewInput(
        Long reviewId,
        Long userId
) {
}
