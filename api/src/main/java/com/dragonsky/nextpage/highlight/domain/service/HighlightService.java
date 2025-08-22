package com.dragonsky.nextpage.highlight.domain.service;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.highlight.application.dto.input.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchInput;
import com.dragonsky.nextpage.highlight.application.dto.input.ModifyHighlightInput;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.member.domain.entity.Member;

import java.util.List;

public interface HighlightService {

    // 하이라이트 생성
    Highlight createHighlight(Member member, Book book, CreateHighlightInput input);

    // 단일 하이라이트 조회
    Highlight getHighlight(Long highlightId);

    // 조건에 따른 하이라이트 조회
    List<Highlight> getHighlights(HighlightSearchInput input);

    // 하이라이트 수정
    void modifyHighlight(Long highlightId, Member member, Book book, ModifyHighlightInput input);

    // 하이라이트 삭제
    void removeHighlight(Long highlightId);
}
