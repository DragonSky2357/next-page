package com.dragonsky.nextpage.highlight.application.dto.input;

public record CreateHighlightInput(
        Long writerId,
        String content,
        Integer page,
        String tags,
        String isbn
) { }

