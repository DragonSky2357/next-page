package com.dragonsky.nextpage.review.presentation.dto.response;

import com.dragonsky.nextpage.review.application.dto.response.GetReviewsResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewsDetailResponse {
    private Long reviewId;
    private Writer writer;
    private Book book;
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
    public static class Writer {
        private Long id;
        private String nickname;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Book {
        private Long id;
        private String title;
        private String author;
        private String pubDate;
        private String publisher;
    }

    public static ReviewsDetailResponse from(GetReviewsResult result) {
        return ReviewsDetailResponse.builder()
                .reviewId(result.getReviewId())
                .title(result.getTitle())
                .content(result.getContent())
                .rating(result.getRating())
                .status(result.getStatus())
                .category(result.getCategory())
                .tag(result.getTag())
                .isPrivate(result.getIsPrivate())
                .writer(Writer.builder()
                        .id(result.getWriterId())
                        .nickname(result.getNickname())
                        .build())
                .book(Book.builder()
                        .id(result.getBookId())
                        .title(result.getBookTitle())
                        .author(result.getAuthor())
                        .pubDate(result.getPubDate())
                        .publisher(result.getPublisher())
                        .build())
                .build();
    }
}
