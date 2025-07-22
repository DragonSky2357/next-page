package com.dragonsky.nextpage.application.review.converter;

import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewApplicationConverter {

    public CreateReviewResponse toCreateReviewResponse(Long reviewId) {
        return new CreateReviewResponse(reviewId);
    }

    public GetReviewResult toResult(Review review) {
        return GetReviewResult.builder()
                .reviewId(review.getId())
                .authorId(review.getAuthor().getId())
                .authorName(review.getAuthor().getNickname())
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .statusCode(review.getStatusCode())
                .categoryCode(review.getCategoryCode())
                .tagCode(review.getTagCode())
                .isPrivate(review.getIsPrivate())
                .build();
    }
}
