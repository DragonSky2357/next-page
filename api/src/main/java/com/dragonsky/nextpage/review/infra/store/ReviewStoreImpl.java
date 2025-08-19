package com.dragonsky.nextpage.review.infra.store;

import com.dragonsky.nextpage.review.domain.entity.Review;
import com.dragonsky.nextpage.review.domain.repository.store.ReviewStore;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.review.infra.jpa.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewStoreImpl implements ReviewStore {

    private static final String LIKE_KEY_PREFIX = "review:like:";

    private final ReviewJpaRepository reviewJpaRepository;
    private final RedisRepository redisRepository;

    @Override
    public Review append(Review review) {
        return reviewJpaRepository.save(review);
    }

    @Override
    public void remove(Review review) {
        reviewJpaRepository.delete(review);
    }

    @Override
    public void toogleLike(Long reviewId, Long memberId) {
        String key = LIKE_KEY_PREFIX + reviewId;
        String memberIdStr = memberId.toString();

        boolean hasLiked = redisRepository.isMemberOfSet(key, memberIdStr);

        if (hasLiked) {
            redisRepository.removeFromSet(key, memberIdStr);
        } else {
            redisRepository.addToSet(key, memberIdStr);
        }
    }
}
