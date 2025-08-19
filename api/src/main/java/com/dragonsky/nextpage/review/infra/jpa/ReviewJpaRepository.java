package com.dragonsky.nextpage.review.infra.jpa;

import com.dragonsky.nextpage.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
}
