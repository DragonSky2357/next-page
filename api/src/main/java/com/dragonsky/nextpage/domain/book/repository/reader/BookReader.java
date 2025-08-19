package com.dragonsky.nextpage.domain.book.repository.reader;

import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.domain.book.vo.BookItem;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.presentation.book.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;

import java.util.Optional;

public interface BookReader {
    // 검색어 기반 캐시 조회 (API 응답)
    Optional<NaverBookResponse> getCachedSearchResults(BookSearchCondition condition);

    // ISBN 기반 단일 캐시 조회 (API 응답)
    Optional<BookItem> getCachedBookByIsbn(String isbn);

    // ISBN 기반 API 캐시 조회 + 옵션
    Optional<NaverBookResponse> getCachedSearchResultsByRequest(BookCacheRequest request);

    // ISBN 기반 DB 조회
    Optional<Book> getBookByIsbn(String isbn);
}
