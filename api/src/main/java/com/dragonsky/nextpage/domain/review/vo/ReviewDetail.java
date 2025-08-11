package com.dragonsky.nextpage.domain.review.vo;

import com.dragonsky.nextpage.domain.review.model.category.Category;
import com.dragonsky.nextpage.domain.review.model.status.Status;
import com.dragonsky.nextpage.domain.review.model.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetail {
    private Long reviewId;
    private Long authorId;
    private String nickname;
    private String title;
    private String content;
    private Integer rating;
    private Status status;
    private Category category;
    private Tag tag;
    private Boolean isPrivate;
}
