package com.dragonsky.nextpage.infrastructure.review.store;

import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStore;
import com.dragonsky.nextpage.infrastructure.review.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewStoreImpl implements ReviewStore {

    private final ReviewJpaRepository reviewJpaRepository;

    @Override
    public Review save(Review review) {
        return reviewJpaRepository.save(review);
    }
}
