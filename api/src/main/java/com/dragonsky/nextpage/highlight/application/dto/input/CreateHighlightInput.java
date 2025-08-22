package com.dragonsky.nextpage.highlight.application.dto.input;

public record CreateHighlightInput(
        String content,
        Integer page,
        String tags
) { }

