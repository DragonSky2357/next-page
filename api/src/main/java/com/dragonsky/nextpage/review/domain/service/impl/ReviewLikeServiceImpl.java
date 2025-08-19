package com.dragonsky.nextpage.review.domain.service.impl;

import com.dragonsky.nextpage.review.domain.service.ReviewLikeService;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewLikeServiceImpl implements ReviewLikeService {

    private final RedisRepository redisRepository;
    private static final String LIKE_KEY_PREFIX = "review:like";

    @Override
    public void likeReview(Long reviewId, Long memberId) {
        String key = LIKE_KEY_PREFIX + reviewId;
        redisRepository.addToSet(key, memberId.toString());
    }

    @Override
    public void unlikeReview(Long reviewId, Long memberId) {
        String key = LIKE_KEY_PREFIX + reviewId;
        redisRepository.getSet(key, String.class).remove(memberId.toString());
    }

    @Override
    public int getLikesCount(Long reviewId) {
        String key = LIKE_KEY_PREFIX + reviewId;
        Set<String> likes = redisRepository.getSet(key, String.class);
        return likes != null ? likes.size() : 0;
    }

    @Override
    public boolean hasLiked(Long reviewId, Long memberId) {
        String key = LIKE_KEY_PREFIX + reviewId;
        Set<String> likes = redisRepository.getSet(key, String.class);
        return likes != null && likes.contains(memberId.toString());
    }
}
