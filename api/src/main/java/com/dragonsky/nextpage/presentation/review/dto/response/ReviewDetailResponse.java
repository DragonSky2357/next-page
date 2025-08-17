package com.dragonsky.nextpage.presentation.review.dto.response;

import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewDetailResponse {
    private Long reviewId;
    private Author author;
    private String title;
    private String content;
    private Integer rating;
    private String status;
    private String category;
    private String tag;
    private Boolean isPrivate;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Author {
        private Long id;
        private String nickname;
    }

    public static ReviewDetailResponse from(GetReviewResult result) {
        return ReviewDetailResponse.builder()
                .reviewId(result.getReviewId())
                .author(Author.builder()
                        .id(result.getAuthorId())
                        .nickname(result.getNickname())
                        .build())
                .title(result.getTitle())
                .content(result.getContent())
                .rating(result.getRating())
                .status(result.getStatus())
                .category(result.getCategory())
                .tag(result.getTag())
                .isPrivate(result.getIsPrivate())
                .build();
    }
}