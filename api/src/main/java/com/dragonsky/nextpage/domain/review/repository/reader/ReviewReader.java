package com.dragonsky.nextpage.domain.review.repository.reader;

import com.dragonsky.nextpage.domain.review.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.vo.ReviewDetail;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;

import java.util.List;
import java.util.Optional;

public interface ReviewReader {
    Optional<Review> read(Long id);

    List<GetReviewsDto> read(ReviewSearchCondition condition);

    long count(ReviewSearchCondition condition);

    List<ReviewDetail> readAllWithDetails();

    List<Review> readByTitle(String title);

    List<Review> search(String keyword);
}