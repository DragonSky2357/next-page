package com.dragonsky.nextpage.highlight.infra.reader;

import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchInput;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.domain.repository.reader.HighlightReader;
import com.dragonsky.nextpage.highlight.infra.dto.response.GetHighlightsDto;
import com.dragonsky.nextpage.highlight.infra.jpa.HighlightJpaRepository;
import com.dragonsky.nextpage.highlight.infra.mapper.HighlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HighlightReaderImpl implements HighlightReader {

    private final HighlightJpaRepository highlightJpaRepository;
    private final HighlightMapper highlightMapper;

    @Override
    public Optional<Highlight> read(Long highlightId) {
        return highlightJpaRepository.findById(highlightId);
    }

    // TODO CURD 이후에 작업
    @Override
    public List<GetHighlightsDto> readGetHighlightsDtoList(HighlightSearchInput input) {
        return List.of();
    }
}
