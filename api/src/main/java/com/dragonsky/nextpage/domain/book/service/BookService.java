package com.dragonsky.nextpage.domain.book.service;

import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

public interface BookService {
    NaverBookResponse searchBooks(BookSearchCondition condition);

    Book createBook(Book book);

    Book getBookByIsbn(String isbn);

    void cacheBookItemByIsbn(BookCacheRequest request);
}
