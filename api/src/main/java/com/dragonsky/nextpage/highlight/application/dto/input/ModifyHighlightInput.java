package com.dragonsky.nextpage.highlight.application.dto.input;

public record ModifyHighlightInput(
        String content,
        Integer page,
        String tags
) {
}
