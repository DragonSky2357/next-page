package com.dragonsky.nextpage.highlight.application.dto.result;

import java.time.LocalDateTime;
import java.util.List;

public record CreateHighlightResult(
        Long highlightId,
        Long bookId,
        Long writerId,
        String bookTitle,
        String content,
        List<String> tags,
        LocalDateTime createdAt
) {}
