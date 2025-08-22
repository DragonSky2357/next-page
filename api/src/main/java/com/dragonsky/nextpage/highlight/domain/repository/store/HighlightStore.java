package com.dragonsky.nextpage.highlight.domain.repository.store;

import com.dragonsky.nextpage.highlight.domain.entity.Highlight;

public interface HighlightStore {
    Highlight save(Highlight highlight); // 하이라이트 등록
    void remove(Highlight highlight);
}
