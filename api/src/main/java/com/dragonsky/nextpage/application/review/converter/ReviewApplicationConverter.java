package com.dragonsky.nextpage.application.review.converter;

import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResponse;
import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewApplicationConverter {

    public CreateReviewResponse toCreateReviewResponse(Long reviewId) {
        return new CreateReviewResponse(reviewId);
    }

    public GetReviewResponse toGetReviewResponse(Review review){
        return new GetReviewResponse();
    }
}
