package com.dragonsky.nextpage.domain.review.entity;

import com.dragonsky.nextpage.domain.commoncode.domain.BaseEntity;
import com.dragonsky.nextpage.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "review")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate = false;

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateRating(Integer rating) {
        this.rating = rating;
    }
}
