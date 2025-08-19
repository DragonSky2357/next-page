package com.dragonsky.nextpage.review.domain.entity.stats;

import com.dragonsky.nextpage.interaction.domain.stats.InteractionStats;
import com.dragonsky.nextpage.review.domain.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_stats")
@Getter
public class ReviewStats extends InteractionStats {

    @Id
    private Long id;

    @Setter
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Review review;

    @Column(name = "comment_count", nullable = false)
    private int commentCount = 0;

    protected ReviewStats() {
    }

    public ReviewStats(Review review) {
        super();
        if (review == null || review.getId() == null) {
            throw new IllegalArgumentException("Review 또는 Review ID가 null일 수 없습니다.");
        }

        this.review = review;
    }

    public void increaseCommentCount(int count) {
        this.commentCount += count;
    }

    public void decreaseCommentCount(int count) {
        this.commentCount = Math.max(0, this.commentCount - count); // 수정됨
    }
}
