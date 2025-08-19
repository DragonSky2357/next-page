package com.dragonsky.nextpage.review.infra.jpa;

import com.dragonsky.nextpage.review.domain.entity.stats.ReviewStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewStatsJpaRepository extends JpaRepository<ReviewStats, Long> {
}
