package com.dragonsky.nextpage.presentation.book.dto.request;

import lombok.Data;

@Data
public class BookSearchCondition {
    private String query = "";
    private int start = 1;
    private int display = 10;
    private String sort = "sim";
}
