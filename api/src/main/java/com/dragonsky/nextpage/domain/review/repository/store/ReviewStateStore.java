package com.dragonsky.nextpage.domain.review.repository.store;

import com.dragonsky.nextpage.domain.review.entity.stats.ReviewStats;

public interface ReviewStateStore {
    ReviewStats save(ReviewStats reviewStats);
}
