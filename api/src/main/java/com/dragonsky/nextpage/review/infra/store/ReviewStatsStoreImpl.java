package com.dragonsky.nextpage.review.infra.store;

import com.dragonsky.nextpage.review.domain.entity.stats.ReviewStats;
import com.dragonsky.nextpage.review.domain.repository.store.ReviewStateStore;
import com.dragonsky.nextpage.review.infra.jpa.ReviewStatsJpaRepository;
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
