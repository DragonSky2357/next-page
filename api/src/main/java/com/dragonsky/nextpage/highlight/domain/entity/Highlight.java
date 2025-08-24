package com.dragonsky.nextpage.highlight.domain.entity;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.domain.entity.BaseEntity;
import com.dragonsky.nextpage.exception.FieldError;
import com.dragonsky.nextpage.exception.ValidationException;
import com.dragonsky.nextpage.highlight.application.dto.input.ModifyHighlightInput;
import com.dragonsky.nextpage.member.domain.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "highlight")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("is_Active = true AND is_Deleted = false")
public class Highlight extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Book 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // Writer(Member) 연관
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Member writer;

    // 하이라이트 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 책 내 위치/페이지
    @Min(value = 0)
    @Column(name = "page")
    private Integer page;

    @Column(length = 255)
    private String tags; // 콤마 구분

    public void update(Book book, ModifyHighlightInput input) {
        if(book != null) this.book = book;
        if (input.content() != null) this.content = input.content();
        if (input.page() != null) this.page = input.page();
        if (input.tags() != null) this.tags = input.tags();
    }

    private void validateUpdate(ModifyHighlightInput input) {
        List<FieldError> errors = new ArrayList<>();

        if (input.content() == null || input.content().isBlank()) {
            errors.add(new FieldError("content", "내용이 비어 있습니다."));
        }

        if (input.page() != null && input.page() < 0) {
            errors.add(new FieldError("page", "페이지는 0 이상이어야 합니다."));
        }

        if (input.tags() != null && input.tags().split(",").length > 5) {
            errors.add(new FieldError("tags", "태그는 최대 5개까지 허용됩니다."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    public boolean isOwner(Member member) {
        return this.writer != null && this.writer.equals(member);
    }
}
