package com.dragonsky.nextpage.domain.book.entity;

import com.dragonsky.nextpage.domain.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn", callSuper = false)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String author;

    @Setter
    private String link;

    private String publisher;

    @Column(nullable = true)
    private LocalDate pubDate;

    @Column(unique = true, nullable = false, length = 20)
    private String isbn;

    @Column(columnDefinition = "TEXT")
    @Setter
    private String description;

    @Setter
    private String image;

    @Setter
    private Integer price;

    @Setter
    private Integer discountPrice;
}