package com.dragonsky.nextpage.application.review.converter;

import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.vo.ReviewDetail;
import com.dragonsky.nextpage.mapper.EnumMapper;
import com.dragonsky.nextpage.response.PageResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewApplicationConverter {

    private final EnumMapper enumMapper;

    public ReviewApplicationConverter(
            @Qualifier("reviewEnumMapper") EnumMapper enumMapper
    ) {
        this.enumMapper = enumMapper;  // ✅ 파라미터명을 필드에 할당해야 합니다.
    }

    public CreateReviewResult toCreateReviewResponse(Long reviewId) {
        return new CreateReviewResult(reviewId);
    }

    public GetReviewResult toResult(Review review) {
        return GetReviewResult.builder()
                .reviewId(review.getId())
                .authorId(review.getAuthor().getId())
                .nickname(review.getAuthor().getNickname())
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .status(String.valueOf(review.getStatus()))
                .category(String.valueOf(review.getCategory()))
                .tag(String.valueOf(review.getTag()))
                .isPrivate(review.getIsPrivate())
                .build();
    }

    public PageResult<GetReviewResult> toResult(PageResult<ReviewDetail> reviews) {
        List<GetReviewResult> resultList = reviews.content().stream()
                .map(review -> GetReviewResult.builder()
                        .reviewId(review.getReviewId())
                        .authorId(review.getAuthorId())
                        .nickname(review.getNickname())
                        .title(review.getTitle())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .status(String.valueOf(review.getStatus()))
                        .category(String.valueOf(review.getCategory()))
                        .tag(String.valueOf(review.getTag()))
                        .isPrivate(review.getIsPrivate())
                        .build())
                .toList();

        return new PageResult<>(
                resultList,
                reviews.page(),
                reviews.size(),
                reviews.total()
        );
    }
}
