package com.dragonsky.nextpage.domain.book.service;

import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

public interface BookService {
    NaverBookResponse searchBooks(BookSearchCondition condition);
}
