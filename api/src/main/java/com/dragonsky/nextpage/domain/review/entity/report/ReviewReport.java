package com.dragonsky.nextpage.domain.review.entity.report;

import com.dragonsky.nextpage.domain.interaction.report.BaseReport;
import com.dragonsky.nextpage.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "review_id"}))
@Getter
public class ReviewReport extends BaseReport {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}
