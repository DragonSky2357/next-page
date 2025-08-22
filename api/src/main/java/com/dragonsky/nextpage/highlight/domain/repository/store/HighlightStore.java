package com.dragonsky.nextpage.highlight.domain.repository.store;

import com.dragonsky.nextpage.highlight.domain.entity.Highlight;

public interface HighlightStore {

    // 하이라이트 등록
    Highlight save(Highlight highlight);

    // 하이라이트 삭제
    void remove(Highlight highlight);
}
