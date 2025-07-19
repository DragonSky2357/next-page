package com.dragonsky.nextpage.application.review;

import com.dragonsky.nextpage.application.review.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResponse;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.service.MemberService;
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
    private final MemberService memberService;

    @Transactional
    public CreateReviewResponse createReview(CreateReviewInput input) {
        Member member = memberService.getMemberById(input.authorId());

        Long reviewId = reviewService.createReview(input, member);

        return reviewConverter.toResponse(reviewId);
    }
}
