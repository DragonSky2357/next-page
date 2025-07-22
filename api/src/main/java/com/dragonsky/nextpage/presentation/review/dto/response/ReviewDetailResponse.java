package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import lombok.Getter;

@Getter
public class ReviewDetailResponse {
    private final Long reviewId;
    private final Long authorId;
    private final String authorName;
    private final String title;
    private final String content;
    private final Integer rating;
    private final Integer statusCode;
    private final Integer categoryCode;
    private final Integer tagCode;
    private final Boolean isPrivate;

    public ReviewDetailResponse(GetReviewResult result) {
        this.reviewId = result.getReviewId();
        this.authorId = result.getAuthorId();
        this.authorName = result.getAuthorName();
        this.title = result.getTitle();
        this.content = result.getContent();
        this.rating = result.getRating();
        this.statusCode = result.getStatusCode();
        this.categoryCode = result.getCategoryCode();
        this.tagCode = result.getTagCode();
        this.isPrivate = result.getIsPrivate();
    }
}
