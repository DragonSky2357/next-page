package com.dragonsky.nextpage.review.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetReviewResult {
    private Long reviewId;
    private Long writerId;
    private String nickname;
    private Long bookId;
    private String bookTitle;
    private String author;
    private String pubDate;
    private String publisher;
    private String title;
    private String content;
    private Integer rating;
    private String status;
    private String statusDesc;
    private String category;
    private String categoryDesc;
    private String tag;
    private String tagDesc;
    private Boolean isPrivate;
}