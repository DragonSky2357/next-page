package com.dragonsky.nextpage.presentation.book.dto.request;

import lombok.Getter;

@Getter
public class BookCacheRequest {
    private String isbn;
    private String query;
    private int start;
    private int display;
    private String sort;
}
