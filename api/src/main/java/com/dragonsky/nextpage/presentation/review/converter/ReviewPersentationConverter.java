package com.dragonsky.nextpage.presentation.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewPersentationConverter {

    public CreateReviewInput fromRequest(CreateReviewRequest request, AuthUser user) {
        return null;
    }

    public CreateReviewApiResponse toApiResponse(CreateReviewResponse response) {
        return new CreateReviewApiResponse(response.reviewId());
    }

    public ReviewDetailResponse toResponse(GetReviewResult result) {
        return new ReviewDetailResponse(result);
    }
}
