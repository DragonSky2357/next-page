package com.dragonsky.nextpage.presentation.review.dto.request;

import jakarta.validation.constraints.*;

public record CreateReviewRequest(

        @NotBlank(message = "제목은 필수입니다.")
        @Size(max = 50, message = "제목은 최대 50자까지 가능합니다.")
        String title,

        @NotBlank(message = "내용은 필수입니다.")
        String content,

        @NotNull(message = "평점은 필수입니다.")
        @Min(value = 1, message = "평점은 1 이상이어야 합니다.")
        @Max(value = 5, message = "평점은 5 이하이어야 합니다.")
        Integer rating,

        @Size(max = 255, message = "검색 키워드는 최대 255자까지 입력 가능합니다.")
        String searchKeywords,

        @NotNull(message = "완독은 필수 항목 입니다.")
        String status,

        @NotNull(message = "카데고리는 필수 항목 입니다.")
        String category,

        @NotNull(message = "태그는 필수 항목입니다.")
        String tag,

        @NotNull(message = "공개 여부를 선택해주세요.")
        Boolean isPrivate

) {
}
