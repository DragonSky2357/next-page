package com.dragonsky.nextpage.review.domain.repository.reader;

import com.dragonsky.nextpage.review.domain.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.review.domain.entity.Review;
import com.dragonsky.nextpage.review.domain.vo.ReviewDetail;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;

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