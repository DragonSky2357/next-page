package com.dragonsky.nextpage.highlight.domain.service;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.highlight.application.dto.request.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.member.domain.entity.Member;

import java.util.List;

public interface HighlightService {

    // 하이라이트 생성
    Highlight createHighlight(Book book, Member member, CreateHighlightInput input);

    // 하이라이트 조회
    Highlight getHighlight(Long HighlightId);

    // 하이라이트 조회(조건)
    List<Highlight> getHighlights(HighLightSearchRequest request);

    // 하이라이트 수정
    Highlight modifyHighlight(Member member, ModifyHighlightInput input);

    // 하이라이트 삭제
    void removeHighlight(Long id);
}
