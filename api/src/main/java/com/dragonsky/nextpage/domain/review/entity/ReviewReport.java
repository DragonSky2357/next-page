package com.dragonsky.nextpage.domain.review.entity;

import com.dragonsky.nextpage.domain.report.AbstractReport;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "review_id"}))
@Getter
public class ReviewReport extends AbstractReport {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}
