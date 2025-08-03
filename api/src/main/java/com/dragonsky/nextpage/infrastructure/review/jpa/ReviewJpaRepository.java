package com.dragonsky.nextpage.infrastructure.review.jpa;

import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
}
