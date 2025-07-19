package com.dragonsky.nextpage.application.review.converter;

import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewApplicationConverter {
    public CreateReviewResponse toResponse(Long reviewId) {
        return new CreateReviewResponse(reviewId);
    }
}
