package com.dragonsky.nextpage.infra.book.store;

import com.dragonsky.nextpage.domain.book.repository.store.BookStore;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor

public class BookStoreImpl implements BookStore {

    private static final Duration BOOK_CACHE_TTL = Duration.ofHours(24);

    private final RedisRepository redisRepository;

    @Override
    public void saveCachedBooks(BookSearchCondition condition, NaverBookResponse response) {
        String key = String.format("bookStore:%s:%d:%d:%s",
                condition.getQuery(), condition.getStart(), condition.getDisplay(), condition.getSort());

        redisRepository.save(key, response, BOOK_CACHE_TTL);
    }
}
