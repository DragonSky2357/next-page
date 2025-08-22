package com.dragonsky.nextpage.review.domain.entity;

import com.dragonsky.nextpage.review.application.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.domain.entity.BaseEntity;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.review.domain.entity.stats.ReviewStats;
import com.dragonsky.nextpage.review.domain.model.category.Category;
import com.dragonsky.nextpage.review.domain.model.status.Status;
import com.dragonsky.nextpage.review.domain.model.tag.Tag;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

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

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    @Enumerated(EnumType.STRING)
    private Tag tag;

    @Column(name = "is_private", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isPrivate;

    @OneToOne(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ReviewStats stats;

    public void update(ModifyReviewInput input) {
        this.title = input.title();
        this.content = input.content();
        this.rating = input.rating();
        this.searchKeywords = input.searchKeywords();
        this.status = Status.valueOf(input.status());
        this.category = Category.valueOf(input.category());
        this.tag = Tag.valueOf(input.tag());
        this.isPrivate = input.isPrivate();
    }
}
