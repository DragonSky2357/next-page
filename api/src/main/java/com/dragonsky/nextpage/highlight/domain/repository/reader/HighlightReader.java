package com.dragonsky.nextpage.highlight.domain.repository.reader;

import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchInput;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.infra.dto.response.GetHighlightsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface HighlightReader {
    Optional<Highlight> read(Long highlightId);

    List<GetHighlightsDto> readGetHighlightsDtoList(HighlightSearchInput input);
}
