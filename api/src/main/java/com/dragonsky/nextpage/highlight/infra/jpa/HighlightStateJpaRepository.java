package com.dragonsky.nextpage.highlight.infra.jpa;

import com.dragonsky.nextpage.highlight.domain.entity.HighlightStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighlightStateJpaRepository extends JpaRepository<HighlightStats, Long> {
}
