package com.dragonsky.nextpage.highlight.domain.repository.store;

import com.dragonsky.nextpage.highlight.domain.entity.HighlightStats;

public interface HighlightStateStore {
    HighlightStats save(HighlightStats highlightStats);
}
