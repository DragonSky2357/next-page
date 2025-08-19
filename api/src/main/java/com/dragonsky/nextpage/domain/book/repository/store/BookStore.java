package com.dragonsky.nextpage.domain.book.repository.store;

import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.domain.book.vo.BookItem;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

public interface BookStore {
    void cacheBooks(BookSearchCondition condition, NaverBookResponse response);

    void cacheBookByIsbn(String isbn, BookItem item);

    Book append(Book book);
}
