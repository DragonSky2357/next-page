package com.dragonsky.nextpage.review.application.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record CreateReviewInput(
        Long authorId,
        String title,
        String content,
        Integer rating,
        String status,
        String category,
        String tag,
        String searchKeywords,
        Boolean isPrivate,
        String isbn,
        List<MultipartFile> images
) {
}
