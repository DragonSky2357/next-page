package com.dragonsky.nextpage.highlight.application.converter;

import com.dragonsky.nextpage.highlight.application.dto.result.CreateHighlightResult;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.util.string.StringUtils;

public class HighlightConverter {

    public CreateHighlightResult toCreateHighlightResult(Highlight highlight) {

        return new CreateHighlightResult(
                highlight.getId(),
                highlight.getBook().getId(),
                highlight.getWriter().getId(),
                highlight.getBook().getTitle(),
                highlight.getContent(),
                StringUtils.splitByComma(highlight.getTags()),
                highlight.getCreatedAt()
        );
    }
}
