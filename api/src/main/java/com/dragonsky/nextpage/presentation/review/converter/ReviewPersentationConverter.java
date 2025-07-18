package com.dragonsky.nextpage.presentation.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import org.springframework.stereotype.Component;

@Component
public class ReviewPersentationConverter {

    public CreateReviewInput fromRequest(CreateReviewRequest request) {
        return CreateReviewInput.builder()
                .title(request.title())
                .content(request.content())
                .rating(request.rating())
                .searchKeywords(request.searchKeywords())
                .statusCode(request.statusCode())
                .categoryCode(request.categoryCode())
                .tagCode(request.tagCode())
                .isPrivate(request.isPrivate())
                .build();
    }

    public CreateReviewApiResponse toApiResponse(CreateReviewResponse response) {
        return new CreateReviewApiResponse(response.reviewId());
    }
}
