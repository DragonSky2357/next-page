package com.dragonsky.nextpage.domain.review.service.impl;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.converter.ReviewConverter;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.entity.stats.ReviewStats;
import com.dragonsky.nextpage.domain.review.exception.ReviewErrorCode;
import com.dragonsky.nextpage.domain.review.exception.ReviewException;
import com.dragonsky.nextpage.domain.review.factory.ReviewFactory;
import com.dragonsky.nextpage.domain.review.repository.reader.ReviewReader;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStateStore;
import com.dragonsky.nextpage.domain.review.repository.store.ReviewStore;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import com.dragonsky.nextpage.domain.review.vo.ReviewDetail;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;
import com.dragonsky.nextpage.response.PageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewFactory reviewFactory;
    private final ReviewReader reviewReader;
    private final ReviewStore reviewStore;
    private final ReviewStateStore reviewStateStore;
    private final ReviewConverter reviewConverter;

    @Override
    public Long createReview(CreateReviewInput input, Member member) {
        Review review = reviewFactory.create(input, member);
        Review savedReview = reviewStore.append(review);
        reviewStateStore.save(new ReviewStats(savedReview));
        return savedReview.getId();
    }

    @Override
    public Review getReview(Long reviewId) {
        return getReviewById(reviewId);
    }

    @Override
    public PageResult<ReviewDetail> getReviews(ReviewSearchCondition condition) {
        List<ReviewDetail> reviews = reviewReader.read(condition);
        long totalCount = reviewReader.count(condition);
        return new PageResult<>(reviews, condition.page(), condition.size(), totalCount);
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

    @Override
    public void likeReview(Long reviewId, Long memberId) {
        reviewStore.toogleLike(reviewId, memberId);
    }

    private Review getReviewById(Long reviewId) {
        return reviewReader.read(reviewId)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND));
    }

    private void validateAuthor(Member author, Member member) {
        if (!Objects.equals(author.getId(), member.getId())) {
            throw new ReviewException(ReviewErrorCode.UNAUTHORIZED_REVIEW_REMOVE);
        }
    }
}
