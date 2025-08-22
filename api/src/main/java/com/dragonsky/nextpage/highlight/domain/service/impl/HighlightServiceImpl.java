package com.dragonsky.nextpage.highlight.domain.service.impl;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.highlight.application.dto.request.CreateHighLightInput;
import com.dragonsky.nextpage.highlight.application.dto.request.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.domain.converter.HighlightConverter;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.domain.entity.HighlightStats;
import com.dragonsky.nextpage.highlight.domain.factory.HighlightFactory;
import com.dragonsky.nextpage.highlight.domain.repository.reader.HightlightReader;
import com.dragonsky.nextpage.highlight.domain.repository.store.HighlightStateStore;
import com.dragonsky.nextpage.highlight.domain.repository.store.HighlightStore;
import com.dragonsky.nextpage.highlight.domain.service.HighlightService;
import com.dragonsky.nextpage.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HighlightServiceImpl implements HighlightService {

    private final HighlightFactory highlightFactory;
    private final HightlightReader hightLightReader;
    private final HighlightStore highlightStore;
    private final HighlightStateStore highlightStateStore;
    private final HighlightConverter highlightConverter;

    @Override
    public Highlight createHighlight(Book book, Member member, CreateHighlightInput input) {
        Highlight highlight = highlightFactory.create(book, member, input);
        Highlight savedHighlight = highlightStore.save(highlight);
        highlightStateStore.save(new HighlightStats(savedHighlight));
        return savedHighlight;
    }

    @Override
    public Highlight getHighlight(Long HighlightId) {
        return null;
    }

    @Override
    public List<Highlight> getHighlights(HighLightSearchRequest request) {
        return List.of();
    }

    @Override
    public Highlight modifyHighlight(Member member, ModifyHighlightInput input) {
        return null;
    }

    @Override
    public void removeHighlight(Long id) {

    }
}
