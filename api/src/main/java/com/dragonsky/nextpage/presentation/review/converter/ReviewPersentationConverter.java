package com.dragonsky.nextpage.presentation.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResponse;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailApiResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewPersentationConverter {

    public CreateReviewInput fromRequest(CreateReviewRequest request, AuthUser user) {
        return null;
    }

    public CreateReviewApiResponse toApiResponse(CreateReviewResponse response) {
        return new CreateReviewApiResponse(response.reviewId());
    }

    public ReviewDetailApiResponse toDetailApiResponse(GetReviewResponse response) {
        return new ReviewDetailApiResponse(response);
    }
}
