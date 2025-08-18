package com.dragonsky.nextpage.domain.book.repository.store;

import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

public interface BookStore {
    void saveCachedBooks(BookSearchCondition condition , NaverBookResponse response);
}
