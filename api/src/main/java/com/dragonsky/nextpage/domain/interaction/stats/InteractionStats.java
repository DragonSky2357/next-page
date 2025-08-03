package com.dragonsky.nextpage.domain.interaction.stats;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class InteractionStats {

    @Column(nullable = false)
    protected int likeCount = 0;

    @Column(nullable = false)
    protected int reportCount = 0;

    @Column(nullable = false)
    protected int viewCount = 0;

    public void increaseLikeCount(int count) {
        this.likeCount += count;
    }

    public void decreaseLikeCount(int count) {
        this.likeCount = Math.max(0, this.likeCount - count);
    }

    public void increaseReportCount(int count) {
        this.reportCount += count;
    }

    public void decreaseReportCount(int count) {
        this.reportCount = Math.max(0, this.reportCount - count);
    }

    public void increaseViewCount(int count) {
        this.viewCount += count;
    }

    public void decreaseViewCount(int count) {
        this.viewCount = Math.max(0, this.viewCount - count);
    }
}