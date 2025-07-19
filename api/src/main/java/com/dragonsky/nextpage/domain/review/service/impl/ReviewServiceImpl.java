package com.dragonsky.nextpage.domain.review.service.impl;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.UpdateReviewInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.converter.ReviewConverter;
import com.dragonsky.nextpage.domain.review.dto.ReviewDetail;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.repository.reader.ReviewReader;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStore;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewConverter reviewConverter;
    private final ReviewReader reviewReader;
    private final ReviewStore reviewStore;

    @Override
    public Long createReview(CreateReviewInput input, Member member) {
        Review review = reviewConverter.toEntity(input, member);

        Review savedReview = reviewStore.save(review);

        return savedReview.getId();
    }

    @Override
    public Review findReview(Long reviewId) {
        return null;
    }

    @Override
    public Page<Review> findReviews(Pageable pageable) {
        return null;
    }

    @Override
    public List<ReviewDetail> getReviews() {
        return List.of();
    }

    @Override
    public void updateReview(Long reviewId, UpdateReviewInput input) {

    }

    @Override
    public void deleteReview(Long reviewId) {

    }
}
