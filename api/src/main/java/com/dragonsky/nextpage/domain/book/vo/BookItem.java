package com.dragonsky.nextpage.domain.book.vo;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookItem {
    private String title;
    private String link;
    private String image;
    private String author;
    private String price;
    private String discount;
    private String publisher;
    private String pubdate;
    private String isbn;

    @Setter
    private String description;
}
