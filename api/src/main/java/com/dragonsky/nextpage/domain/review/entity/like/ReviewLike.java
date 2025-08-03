package com.dragonsky.nextpage.domain.review.entity.like;

import com.dragonsky.nextpage.domain.interaction.like.BaseLike;
import com.dragonsky.nextpage.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@IdClass(ReviewLikeId.class)
@Table(name = "review_like", uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "review_id"}))
public class ReviewLike extends BaseLike {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    public ReviewLike(Long memberId, Review review) {
        super(memberId);
        this.review = review;
    }
}
