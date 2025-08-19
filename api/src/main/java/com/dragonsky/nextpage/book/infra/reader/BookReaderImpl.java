package com.dragonsky.nextpage.book.infra.reader;

import com.dragonsky.nextpage.book.domain.converter.BookConverter;
import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.book.domain.repository.reader.BookReader;
import com.dragonsky.nextpage.book.domain.vo.BookItem;
import com.dragonsky.nextpage.book.infra.jpa.BookJpaRepository;
import com.dragonsky.nextpage.book.infra.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.book.presentation.dto.request.BookCacheRequest;
import com.dragonsky.nextpage.book.presentation.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookReaderImpl implements BookReader {

    private final BookConverter converter;
    private final BookJpaRepository bookJpaRepository;
    private final RedisRepository redisRepository;

    @Override
    public Optional<NaverBookResponse> getCachedSearchResults(BookSearchCondition condition) {
        String key = String.format("books:%s:%d:%d:%s",
                condition.getQuery(), condition.getStart(), condition.getDisplay(), condition.getSort());

        return redisRepository.get(key, NaverBookResponse.class);
    }

    @Override
    public Optional<BookItem> getCachedBookByIsbn(String isbn) {
        String key = String.format("books:isbn:%s", isbn);

        return redisRepository.get(key, BookItem.class);
    }

    @Override
    public Optional<NaverBookResponse> getCachedSearchResultsByRequest(BookCacheRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookJpaRepository.findByIsbn(isbn);
    }
}
