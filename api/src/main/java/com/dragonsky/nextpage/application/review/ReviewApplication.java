package com.dragonsky.nextpage.application.review;

import com.dragonsky.nextpage.application.review.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewApplication {

    private final ReviewApplicationConverter reviewConverter;
    private final ReviewService reviewService;
    private final MemberService memberService;

    @Transactional
    public CreateReviewResponse createReview(CreateReviewInput input) {
        Member member = memberService.getMemberById(input.authorId());

        Long reviewId = reviewService.createReview(input, member);

        return reviewConverter.toCreateReviewResponse(reviewId);
    }

    public GetReviewResult getReview(Long reviewId) {
        Review review = reviewService.getReview(reviewId);

        return reviewConverter.toResult(review);
    }

    public Page<GetReviewResult> getReviews(Pageable pageable){
        Page<Review> reviews = reviewService.getReviews(pageable);

        return reviews.map(reviewConverter::toResult);
    }

}
