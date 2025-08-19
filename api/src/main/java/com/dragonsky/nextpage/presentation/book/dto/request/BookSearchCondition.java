package com.dragonsky.nextpage.presentation.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchCondition {
    private String query = "";
    private int start = 1;
    private int display = 10;
    private String sort = "sim";
}
