package com.dragonsky.nextpage.infra.book.naver.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class NaverBookRssResponse {

    @JacksonXmlProperty(isAttribute = true) // version 속성 매핑
    private String version;

    private Channel channel;

    @Data
    public static class Channel {
        private String title;
        private String link;
        private String description;
        private String lastBuildDate;
        private int total;
        private int start;
        private int display;

        @JacksonXmlElementWrapper(useWrapping = false)
        private List<Item> item;
    }

    @Data
    public static class Item {
        private String title;
        private String link;
        private String image;
        private String author;
        private String discount;
        private String publisher;
        private String pubdate;
        private String isbn;
        private String description;
    }
}
