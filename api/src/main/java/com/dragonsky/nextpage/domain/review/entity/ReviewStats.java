package com.dragonsky.nextpage.domain.review.entity;

import com.dragonsky.nextpage.domain.stats.AbstractStats;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_stats")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewStats extends AbstractStats {

    @Id
    private Long id;

    @Setter
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Review review;

    @Column(name = "comment_count", nullable = false)
    private int commentCount = 0;

    public void increaseCommentCount(int count) {
        this.commentCount += count;
    }

    public void decreaseCommentCount(int count) {
        this.viewCount = Math.max(0, this.viewCount - count);
    }
}
