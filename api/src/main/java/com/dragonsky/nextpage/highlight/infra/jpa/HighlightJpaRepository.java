package com.dragonsky.nextpage.highlight.infra.jpa;

import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighlightJpaRepository extends JpaRepository<Highlight, Long> {
}
