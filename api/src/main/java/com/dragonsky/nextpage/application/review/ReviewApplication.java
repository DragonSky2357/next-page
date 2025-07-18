package com.dragonsky.nextpage.application.review;

import com.dragonsky.nextpage.application.review.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewApplication {

    private final ReviewApplicationConverter reviewConverter;
    private final ReviewService reviewService;

    @Transactional
    public CreateReviewResponse createReview(CreateReviewInput createReviewInput) {

        return null;
    }
}
