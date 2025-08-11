package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.response.PageResult;
import lombok.Getter;

import java.util.List;

@Getter
public class ReviewListResponse {
    private final List<ReviewDetailResponse> reviews;
    private final int page;
    private final int size;
    private final long total;

    public ReviewListResponse(PageResult<GetReviewResult> result) {
        this.reviews = result.content().stream()
                .map(ReviewDetailResponse::new)
                .toList();
        this.page = result.page();
        this.size = result.size();
        this.total = result.total();
    }
}