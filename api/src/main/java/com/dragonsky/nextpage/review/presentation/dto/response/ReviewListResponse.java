package com.dragonsky.nextpage.review.presentation.dto.response;

import com.dragonsky.nextpage.review.application.dto.response.GetReviewsResult;
import com.dragonsky.nextpage.response.PageResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewListResponse {
    private final List<ReviewsDetailResponse> reviews;
    private final int page;
    private final int size;
    private final long total;

    public static ReviewListResponse from(PageResult<GetReviewsResult> result) {
        List<ReviewsDetailResponse> reviewResponses = result.content().stream()
                .map(ReviewsDetailResponse::from)
                .toList();

        return ReviewListResponse.builder()
                .reviews(reviewResponses)
                .page(result.page())
                .size(result.size())
                .total(result.total())
                .build();
    }
}