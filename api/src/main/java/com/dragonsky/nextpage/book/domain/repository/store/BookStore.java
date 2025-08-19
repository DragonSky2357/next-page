package com.dragonsky.nextpage.book.domain.repository.store;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.book.domain.vo.BookItem;
import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.book.presentation.dto.request.BookSearchCondition;

public interface BookStore {
    void cacheBooks(BookSearchCondition condition, NaverBookResponse response);

    void cacheBookByIsbn(String isbn, BookItem item);

    Book append(Book book);
}
