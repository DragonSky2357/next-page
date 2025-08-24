package com.dragonsky.nextpage.highlight.infra.mapper;

import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchInput;
import com.dragonsky.nextpage.highlight.infra.dto.response.GetHighlightsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HighlightMapper {
    List<GetHighlightsDto> searchHighlight(HighlightSearchInput input);
    int countHighlights(HighlightSearchInput input);
}
