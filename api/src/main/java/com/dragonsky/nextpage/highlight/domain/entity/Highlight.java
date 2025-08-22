package com.dragonsky.nextpage.highlight.domain.entity;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.member.domain.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "highlight")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("is_Active = true AND is_Deleted = false")
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Book 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // Member 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 하이라이트 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 책 내 위치/페이지
    @Min(value = 0)
    @Column(name = "page")
    private Integer page;

    @Column(length = 255)
    private String tags; // 콤마 구분

}
