package com.dragonsky.nextpage.application.book;

import com.dragonsky.nextpage.application.book.converter.BookApplicationConverter;
import com.dragonsky.nextpage.application.book.dto.response.GetSearchBooksResult;
import com.dragonsky.nextpage.domain.book.service.BookService;
import com.dragonsky.nextpage.presentation.book.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BookApplication {

    private final BookApplicationConverter bookConverter;
    private final BookService bookService;

    public GetSearchBooksResult searchBook(BookSearchCondition condition) {
        var books = bookService.searchBooks(condition);

        return bookConverter.toResult(books);
    }

    public void cacheBookFromClient(BookCacheRequest request) {
        bookService.cacheBookItemByIsbn(request);
    }
}
