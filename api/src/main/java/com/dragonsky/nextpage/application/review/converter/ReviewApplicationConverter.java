package com.dragonsky.nextpage.application.review.converter;

import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewsResult;
import com.dragonsky.nextpage.domain.review.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.domain.review.entity.Review;
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
                .writerId(review.getAuthor().getId())
                .nickname(review.getAuthor().getNickname())
                .bookId(review.getBook().getId())
                .bookTitle(review.getBook().getTitle())
                .author(review.getBook().getAuthor())
                .pubDate(String.valueOf(review.getBook().getPubDate()))
                .publisher(review.getBook().getPublisher())
                .title(review.getTitle())
                .content(review.getContent())
                .rating(review.getRating())
                .status(String.valueOf(review.getStatus()))
                .category(String.valueOf(review.getCategory()))
                .tag(String.valueOf(review.getTag()))
                .isPrivate(review.getIsPrivate())
                .build();
    }

    public PageResult<GetReviewsResult> toResult(PageResult<GetReviewsDto> reviews) {
        List<GetReviewsResult> resultList = reviews.content().stream()
                .map(review -> GetReviewsResult.builder()
                        .reviewId(review.getReviewId())
                        .writerId(review.getWriterId())
                        .nickname(review.getNickname())
                        .bookId(review.getBookId())
                        .bookTitle(review.getBookTitle())
                        .author(review.getBookAuthor())
                        .pubDate(review.getBookPubDate())
                        .publisher(review.getBookPublisher())
                        .title(review.getReviewTitle())
                        .content(review.getReviewContent())
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
