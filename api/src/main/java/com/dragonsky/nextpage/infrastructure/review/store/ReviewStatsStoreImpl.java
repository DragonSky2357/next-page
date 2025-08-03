package com.dragonsky.nextpage.infrastructure.review.store;

import com.dragonsky.nextpage.domain.review.entity.stats.ReviewStats;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStateStore;
import com.dragonsky.nextpage.infrastructure.review.jpa.ReviewStatsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewStatsStoreImpl implements ReviewStateStore {

    private final ReviewStatsJpaRepository reviewStatsJpaRepository;

    @Override
    public ReviewStats save(ReviewStats reviewStats) {
        return reviewStatsJpaRepository.save(reviewStats);
    }
}
