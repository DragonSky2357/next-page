package com.dragonsky.nextpage.presentation.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.application.review.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.application.review.dto.response.GetReviewResult;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.request.ModifyReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewListResponse;
import com.dragonsky.nextpage.response.PageResult;
import org.springframework.stereotype.Component;

@Component
public class ReviewPersentationConverter {

    public CreateReviewInput fromRequest(CreateReviewRequest request, AuthUser user) {
        return new CreateReviewInput(
                user.getId(),
                request.title(),
                request.content(),
                request.rating(),
                request.status(),
                request.category(),
                request.tag(),
                request.searchKeywords(),
                request.isPrivate()
        );
    }

    public CreateReviewApiResponse toResponse(CreateReviewResult result) {
        return new CreateReviewApiResponse(result.reviewId());
    }

    public ReviewDetailResponse toResponse(GetReviewResult result) {
        return ReviewDetailResponse.from(result);
    }

    public ReviewListResponse toResponse(PageResult<GetReviewResult> result) {
        return ReviewListResponse.from(result);
    }

    public ModifyReviewInput fromRequest(Long reviewId, ModifyReviewRequest request, AuthUser user) {
        return new ModifyReviewInput(
                reviewId,
                user.getId(),
                request.title(),
                request.content(),
                request.rating(),
                request.searchKeywords(),
                request.status(),
                request.category(),
                request.tag(),
                request.isPrivate()
        );
    }

    public RemoveReviewInput fromRequest(Long reviewId, AuthUser user) {
        return new RemoveReviewInput(
                reviewId,
                user.getId()
        );
    }
}
