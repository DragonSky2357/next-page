package com.dragonsky.nextpage.domain.review.service.impl;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.converter.ReviewConverter;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.exception.ReviewErrorCode;
import com.dragonsky.nextpage.domain.review.exception.ReviewException;
import com.dragonsky.nextpage.domain.review.repository.reader.ReviewReader;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStore;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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
    public Review getReview(Long reviewId) {
        return getReviewById(reviewId);
    }

    @Override
    public Page<Review> getReviews(Pageable pageable) {
        return reviewReader.findAll(pageable);
    }

    @Override
    public void modifyReview(Member member, ModifyReviewInput input) {
        Review review = getReview(input.reviewId());

        Member author = review.getAuthor();
        validateAuthor(author, member);

        review.update(input);
    }

    @Override
    public void removeReview(Member member, RemoveReviewInput input) {
        Review review = getReview(input.reviewId());

        Member author = review.getAuthor();
        validateAuthor(author, member);

        reviewStore.remove(review);
    }

    private Review getReviewById(Long reviewId) {
        return reviewReader.findById(reviewId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND));
    }

    private void validateAuthor(Member author, Member member) {
        if (!Objects.equals(author.getId(), member.getId())) {
            throw new ReviewException(ReviewErrorCode.UNAUTHORIZED_REVIEW_REMOVE);
        }
    }
}
