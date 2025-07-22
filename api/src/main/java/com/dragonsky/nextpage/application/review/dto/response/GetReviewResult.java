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
    private String authorName;
    private String title;
    private String content;
    private Integer rating;
    private Integer statusCode;
    private Integer categoryCode;
    private Integer tagCode;
    private Boolean isPrivate;
}