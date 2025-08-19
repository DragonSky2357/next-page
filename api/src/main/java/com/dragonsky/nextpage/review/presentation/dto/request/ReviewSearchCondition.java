package com.dragonsky.nextpage.review.presentation.dto.request;

public record ReviewSearchCondition(
        String keyword,
        String status,
        String category,
        String tag,
        String sortBy,
        int page,
        int size
) {
    public ReviewSearchCondition {
        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "RECENT";
        }
        if (page < 0) {
            page = 0;
        }
        if (size <= 0) {
            size = 20;
        }
    }

    public int offset() {
        return page * size;
    }
}
