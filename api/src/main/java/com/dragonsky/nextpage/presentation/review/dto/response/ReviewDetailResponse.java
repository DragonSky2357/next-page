package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import lombok.Getter;

@Getter
public class ReviewDetailResponse {
    private final Long reviewId;
    private final Long authorId;
    private final String nickname;
    private final String title;
    private final String content;
    private final Integer rating;
    private final String status;
    private final String category;
    private final String tag;
    private final Boolean isPrivate;

    public ReviewDetailResponse(GetReviewResult result) {
        this.reviewId = result.getReviewId();
        this.authorId = result.getAuthorId();
        this.nickname = result.getNickname();
        this.title = result.getTitle();
        this.content = result.getContent();
        this.rating = result.getRating();
        this.status = String.valueOf(result.getStatus());
        this.category = String.valueOf(result.getCategory());
        this.tag = String.valueOf(result.getTag());
        this.isPrivate = result.getIsPrivate();
    }
}
