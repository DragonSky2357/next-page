package com.dragonsky.nextpage.presentation.review.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record ModifyReviewRequest(

        @Size(max = 50, message = "제목은 최대 50자까지 가능합니다.")
        String title,

        String content,

        @Min(1)
        @Max(5)
        Integer rating,

        @Size(max = 255)
        String searchKeywords,

        String status,

        String category,

        String tag,

        Boolean isPrivate
) {
}
