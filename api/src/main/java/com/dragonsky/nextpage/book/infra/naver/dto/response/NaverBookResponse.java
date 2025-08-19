package com.dragonsky.nextpage.book.infra.naver.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class NaverBookResponse {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;

    @Getter
    public static class Item {
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
}