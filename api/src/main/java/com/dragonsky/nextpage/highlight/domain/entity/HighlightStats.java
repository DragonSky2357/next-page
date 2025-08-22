package com.dragonsky.nextpage.highlight.domain.entity;

import com.dragonsky.nextpage.interaction.domain.stats.InteractionStats;
import com.dragonsky.nextpage.review.domain.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "review_stats")
@Getter
public class HighlightStats extends InteractionStats {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Highlight highlight;

    // 하이라이트 공유 횟수
    @Column(name = "share_count", nullable = false)
    private Integer shareCount = 0;

    // 북마크 횟수
    @Column(name = "bookmark_count", nullable = false)
    private Integer bookmarkCount = 0;

    // 댓글 수
    @Column(name = "comment_count", nullable = false)
    private Integer commentCount = 0;

    // 통계 업데이트 날짜
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt = LocalDateTime.now();

    protected HighlightStats(){}

    public HighlightStats(Highlight highlight){
        super();
        if(highlight == null || highlight.getId() == null){
            throw new IllegalArgumentException("하이라이트 또는 하이라이트 ID가 null일 수 없습니다.");
        }

        this.highlight = highlight;
    }
}
