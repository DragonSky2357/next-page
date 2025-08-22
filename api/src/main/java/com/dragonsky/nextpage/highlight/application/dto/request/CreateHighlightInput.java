package com.dragonsky.nextpage.highlight.application.dto.request;

public record CreateHighlightInput(
        String content,
        Integer page,
        String tags
) { }

