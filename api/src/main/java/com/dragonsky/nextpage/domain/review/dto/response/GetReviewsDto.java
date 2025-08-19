package com.dragonsky.nextpage.domain.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetReviewsDto {

    // 리뷰 정보
    private Long reviewId;
    private String reviewTitle;
    private String reviewContent;
    private Integer rating;
    private String status;
    private String category;
    private String tag;
    private Boolean isPrivate;
    private String createdAt;

    // 작성자 정보
    private Long writerId;
    private String nickname;

    // 도서 정보
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPubDate;
    private String bookPublisher;
}
