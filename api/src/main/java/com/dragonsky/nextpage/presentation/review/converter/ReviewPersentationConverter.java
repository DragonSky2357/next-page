package com.dragonsky.nextpage.presentation.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewPersentationConverter {

    public CreateReviewInput fromRequest(CreateReviewRequest request, AuthUser user) {
        return new CreateReviewInput(
                user.getId(),
                request.title(),
                request.content(),
                request.rating(),
                request.statusCode(),
                request.categoryCode(),
                request.tagCode(),
                request.searchKeywords(),
                request.isPrivate()
        );
    }

    public CreateReviewApiResponse toResponse(CreateReviewResult result) {
        return new CreateReviewApiResponse(result.reviewId());
    }

    public ReviewDetailResponse toResponse(GetReviewResult result) {
        return new ReviewDetailResponse(result);
    }
}
