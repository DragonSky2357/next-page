package com.dragonsky.nextpage.application.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetReviewResult {
    private Long reviewId;
    private Long authorId;
    private String nickname;
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