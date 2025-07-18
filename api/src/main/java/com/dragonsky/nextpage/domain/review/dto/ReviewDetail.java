package com.dragonsky.nextpage.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewDetail {
    private Long reviewId;
    private String title;
    private String content;
    private Integer rating;
    private String authorName; // 작성자 이름
    private String categoryName; // 카테고리 이름
    private LocalDateTime createdAt;
}
