package com.dragonsky.nextpage.review.application.dto.request;

public record RemoveReviewInput(
        Long reviewId,
        Long userId
) {
}
