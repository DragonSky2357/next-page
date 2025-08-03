package com.dragonsky.nextpage.infrastructure.review.jpa;

import com.dragonsky.nextpage.domain.review.entity.stats.ReviewStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewStatsJpaRepository extends JpaRepository<ReviewStats, Long> {
}
