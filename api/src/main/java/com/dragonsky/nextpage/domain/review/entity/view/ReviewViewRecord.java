package com.dragonsky.nextpage.domain.review.entity.view;

import com.dragonsky.nextpage.domain.interaction.view.BaseViewRecord;
import com.dragonsky.nextpage.domain.review.entity.Review;
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
