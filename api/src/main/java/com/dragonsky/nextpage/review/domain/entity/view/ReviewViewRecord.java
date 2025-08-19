package com.dragonsky.nextpage.review.domain.entity.view;

import com.dragonsky.nextpage.interaction.domain.view.BaseViewRecord;
import com.dragonsky.nextpage.review.domain.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "review_id"}))
@Getter
public class ReviewViewRecord extends BaseViewRecord {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}
