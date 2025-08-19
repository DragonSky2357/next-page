package com.dragonsky.nextpage.book.domain.service;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.book.presentation.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.book.presentation.dto.request.BookSearchCondition;

public interface BookService {
    NaverBookResponse searchBooks(BookSearchCondition condition);

    Book createBook(Book book);

    Book getBookByIsbn(String isbn);

    void cacheBookItemByIsbn(BookCacheRequest request);
}
