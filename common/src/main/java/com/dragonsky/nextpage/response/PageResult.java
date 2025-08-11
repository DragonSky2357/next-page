package com.dragonsky.nextpage.response;

import java.util.List;

public record PageResult<T>(
        List<T> content,
        int page,
        int size,
        long total
) {
    public int getTotalPages() {
        return (int) Math.ceil((double) total / size);
    }
}
