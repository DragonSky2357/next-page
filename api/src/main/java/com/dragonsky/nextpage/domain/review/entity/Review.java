package com.dragonsky.nextpage.domain.review.entity;

import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.domain.commoncode.domain.BaseEntity;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.entity.stats.ReviewStats;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "review")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("is_Active = true AND is_Deleted = false")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Member author;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(nullable = false)
    private Integer rating;

    @Column(name = "search_keywords")
    private String searchKeywords;

    @Column(name = "status_code")
    private Integer statusCode;

    @Column(name = "category_code")
    private Integer categoryCode;

    @Column(name = "tag_code")
    private Integer tagCode;

    @Column(name = "is_private", nullable = false, columnDefinition = "DEFAULT FALSE")
    private Boolean isPrivate;

    @OneToOne(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ReviewStats stats;

    public void setStats(ReviewStats stats) {
        this.stats = stats;
        stats.setReview(this);
    }

    public void update(ModifyReviewInput input) {
        this.title = input.title();
        this.content = input.content();
        this.rating = input.rating();
        this.searchKeywords = input.searchKeywords();
        this.statusCode = input.statusCode();
        this.categoryCode = input.categoryCode();
        this.tagCode = input.tagCode();
        this.isPrivate = input.isPrivate();
    }
}
