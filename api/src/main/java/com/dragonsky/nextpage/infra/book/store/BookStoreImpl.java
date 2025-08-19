package com.dragonsky.nextpage.infra.book.store;

import com.dragonsky.nextpage.domain.book.entity.Book;
import com.dragonsky.nextpage.domain.book.repository.store.BookStore;
import com.dragonsky.nextpage.domain.book.vo.BookItem;
import com.dragonsky.nextpage.infra.book.jpa.BookJpaRepository;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor

public class BookStoreImpl implements BookStore {

    private static final Duration BOOK_CACHE_TTL = Duration.ofHours(1);
    private static final Duration BOOK_ISBN_CACHE_TTL = Duration.ofMinutes(30);

    private final BookJpaRepository bookJpaRepository;
    private final RedisRepository redisRepository;


    @Override
    public void cacheBooks(BookSearchCondition condition, NaverBookResponse response) {
        String key = String.format("books:%s:%d:%d:%s",
                condition.getQuery(), condition.getStart(), condition.getDisplay(), condition.getSort());

        redisRepository.save(key, response, BOOK_CACHE_TTL);
    }

    @Override
    public void cacheBookByIsbn(String isbn, BookItem item) {
        String key = String.format("books:isbn:%s", isbn);

        redisRepository.save(key, item, BOOK_ISBN_CACHE_TTL);
    }

    @Override
    public Book append(Book book) {
        return bookJpaRepository.save(book);
    }
}
