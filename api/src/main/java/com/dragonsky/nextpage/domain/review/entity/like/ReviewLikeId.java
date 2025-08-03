package com.dragonsky.nextpage.domain.review.entity.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewLikeId implements Serializable {
    private Long memberId;
    private Long review;
}
