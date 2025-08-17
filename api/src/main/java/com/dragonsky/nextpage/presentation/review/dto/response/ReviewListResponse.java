package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.response.PageResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReviewListResponse {
    private final List<ReviewDetailResponse> reviews;
    private final int page;
    private final int size;
    private final long total;

    public static ReviewListResponse from(PageResult<GetReviewResult> result) {
        List<ReviewDetailResponse> reviewResponses = result.content().stream()
                .map(ReviewDetailResponse::from)
                .toList();

        return ReviewListResponse.builder()
                .reviews(reviewResponses)
                .page(result.page())
                .size(result.size())
                .total(result.total())
                .build();
    }
}