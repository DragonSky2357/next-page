package com.dragonsky.nextpage.domain.review.repository.store;

import com.dragonsky.nextpage.domain.review.entity.Review;

public interface ReviewStore {
    Review save(Review review);
    void remove(Review review);
}
