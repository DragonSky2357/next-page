package com.dragonsky.nextpage.infra.book.reader;

import com.dragonsky.nextpage.domain.book.repository.reader.BookReader;
import com.dragonsky.nextpage.infra.book.jpa.BookJpaRepository;
import com.dragonsky.nextpage.infra.book.naver.dto.response.NaverBookResponse;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.presentation.book.dto.request.BookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookReaderImpl implements BookReader {

    private final BookJpaRepository bookJpaRepository;
    private final RedisRepository redisRepository;

    @Override
    public Optional<NaverBookResponse> getCachedBooks(BookSearchCondition condition) {

        String key = String.format("bookStore:%s:%d:%d:%s",
                condition.getQuery(), condition.getStart(), condition.getDisplay(), condition.getSort());

        return redisRepository.get(key, NaverBookResponse.class);
    }

    @Override
    public Optional<NaverBookResponse> getBooks(BookSearchCondition condition) {

        return Optional.empty();
    }
}
