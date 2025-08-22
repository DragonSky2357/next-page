package com.dragonsky.nextpage.highlight.infra.store;

import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.domain.repository.store.HighlightStore;
import com.dragonsky.nextpage.highlight.infra.jpa.HighlightJpaRepository;
import com.dragonsky.nextpage.infra.redis.repository.RedisRepository;
import com.dragonsky.nextpage.review.domain.entity.Review;
import com.dragonsky.nextpage.review.domain.repository.store.ReviewStore;
import com.dragonsky.nextpage.review.infra.jpa.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HighlightStoreImpl implements HighlightStore {

    private static final String LIKE_KEY_PREFIX = "review:like:";

    private final HighlightJpaRepository highlightJpaRepository;

    @Override
    public Highlight save(Highlight highlight) {
        return highlightJpaRepository.save(highlight);
    }

    @Override
    public void remove(Highlight highlight) {
        highlightJpaRepository.delete(highlight);
    }
}
