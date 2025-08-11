package com.dragonsky.nextpage.application.review;

import com.dragonsky.nextpage.application.review.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.service.ReviewService;
import com.dragonsky.nextpage.domain.review.vo.ReviewDetail;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;
import com.dragonsky.nextpage.response.PageResult;
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
    private final MemberService memberService;

    @Transactional
    public CreateReviewResult createReview(CreateReviewInput input) {
        Member member = memberService.getMemberById(input.authorId());

        Long reviewId = reviewService.createReview(input, member);

        return reviewConverter.toCreateReviewResponse(reviewId);
    }

    public GetReviewResult getReview(Long reviewId) {
        Review review = reviewService.getReview(reviewId);

        return reviewConverter.toResult(review);
    }

    public PageResult<GetReviewResult> getReviews(ReviewSearchCondition condition) {
        PageResult<ReviewDetail> reviews = reviewService.getReviews(condition);

        return reviewConverter.toResult(reviews);
    }

    @Transactional
    public void modifyReview(ModifyReviewInput input) {
        Member member = memberService.getMemberById(input.userId());

        reviewService.modifyReview(member, input);
    }

    @Transactional
    public void removeReview(RemoveReviewInput input) {
        Member member = memberService.getMemberById(input.userId());

        reviewService.removeReview(member, input);
    }

    public void likeReview(Long reviewId, Long memberId) {
        Member member = memberService.getMemberById(memberId);

        reviewService.likeReview(reviewId, member.getId());
    }
}

