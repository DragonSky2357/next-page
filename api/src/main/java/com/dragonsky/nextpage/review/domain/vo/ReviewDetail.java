package com.dragonsky.nextpage.review.domain.vo;

import com.dragonsky.nextpage.review.domain.model.category.Category;
import com.dragonsky.nextpage.review.domain.model.status.Status;
import com.dragonsky.nextpage.review.domain.model.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetail {
    private Long reviewId;
    private Long writerId;
    private String nickname;
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookPubDate;
    private String bookPublisher;
    private String reviewTitle;
    private String reviewContent;
    private Integer rating;
    private Status status;
    private Category category;
    private Tag tag;
    private Boolean isPrivate;
}
