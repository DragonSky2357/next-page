package com.dragonsky.nextpage.review.domain.repository.store;

import com.dragonsky.nextpage.review.domain.entity.stats.ReviewStats;

public interface ReviewStateStore {
    ReviewStats save(ReviewStats reviewStats);
}
