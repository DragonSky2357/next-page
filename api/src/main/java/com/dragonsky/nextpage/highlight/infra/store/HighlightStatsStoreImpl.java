package com.dragonsky.nextpage.highlight.infra.store;

import com.dragonsky.nextpage.highlight.domain.entity.HighlightStats;
import com.dragonsky.nextpage.highlight.domain.repository.store.HighlightStateStore;
import com.dragonsky.nextpage.highlight.infra.jpa.HighlightStateJpaRepository;
import com.dragonsky.nextpage.review.domain.entity.stats.ReviewStats;
import com.dragonsky.nextpage.review.domain.repository.store.ReviewStateStore;
import com.dragonsky.nextpage.review.infra.jpa.ReviewStatsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HighlightStatsStoreImpl implements HighlightStateStore {

    private final HighlightStateJpaRepository highlightStateJpaRepository;


    @Override
    public HighlightStats save(HighlightStats highlightStats) {
        return highlightStateJpaRepository.save(highlightStats);
    }
}
