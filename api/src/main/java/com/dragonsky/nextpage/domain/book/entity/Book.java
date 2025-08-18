package com.dragonsky.nextpage.domain.book.entity;

import com.dragonsky.nextpage.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String pubDate;
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;
    private Integer price;
    private Integer discountPrice;
}
