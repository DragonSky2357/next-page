package com.dragonsky.nextpage.domain.book.repository.reader;

import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

import java.util.Optional;

public interface BookReader {
    Optional<NaverBookResponse> getCachedBooks(BookSearchCondition condition);

    Optional<NaverBookResponse> getBooks(BookSearchCondition condition);
}
