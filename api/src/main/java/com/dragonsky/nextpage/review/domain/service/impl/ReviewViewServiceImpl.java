package com.dragonsky.nextpage.review.domain.service.impl;

import com.dragonsky.nextpage.review.domain.service.ReviewViewService;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewViewServiceImpl implements ReviewViewService {

    private final RedisRepository redisRepository;
    private static final String VIEW_COUNT_KEY_PREFIX = "review:view:";

    /**
     * 리뷰 조회수 1 증가
     */
    @Override
    public void incrementViewCount(Long reviewId) {
        String key = VIEW_COUNT_KEY_PREFIX + reviewId;
        redisRepository.increment(key, 1);
    }

    /**
     * 리뷰 조회수 조회
     */
    @Override
    public int getViewCount(Long reviewId) {
        String key = VIEW_COUNT_KEY_PREFIX + reviewId;
        Optional<Integer> optional = redisRepository.get(key, Integer.class);
        return optional.map(o -> (Integer) o).orElse(0);
    }
}
