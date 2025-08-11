package com.dragonsky.nextpage.presentation.review.controller;

import com.dragonsky.nextpage.application.review.ReviewApplication;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.domain.auth.annotation.AuthenticatedUser;
import com.dragonsky.nextpage.presentation.review.converter.ReviewPersentationConverter;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.request.ModifyReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewListResponse;
import com.dragonsky.nextpage.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewPersentationConverter reviewConverter;
    private final ReviewApplication reviewApplication;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateReviewApiResponse>> createReview(
            @Valid @RequestBody CreateReviewRequest request,
            @AuthenticatedUser AuthUser user
    ) {
        var input = reviewConverter.fromRequest(request, user);
        var result = reviewApplication.createReview(input);
        var response = reviewConverter.toResponse(result);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("리뷰가 성공적으로 등록되었습니다.", response));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDetailResponse> getReview(@PathVariable Long reviewId) {
        var result = reviewApplication.getReview(reviewId);
        var response = reviewConverter.toResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ReviewListResponse> getReviews(
            ReviewSearchCondition condition
    ) {
        var result = reviewApplication.getReviews(condition);
        var response = reviewConverter.toResponse(result);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Void>> modifyReview(
            @PathVariable Long reviewId,
            @AuthenticatedUser AuthUser user,
            @RequestBody ModifyReviewRequest request
    ) {
        var input = reviewConverter.fromRequest(reviewId, request, user);
        reviewApplication.modifyReview(input);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("리뷰가 성공적으로 수정되었습니다."));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<Void>> removeReview(
            @PathVariable Long reviewId,
            @AuthenticatedUser AuthUser user
    ) {
        var input = reviewConverter.fromRequest(reviewId, user);
        reviewApplication.removeReview(input);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("리뷰가 성공적으로 삭제되었습니다."));
    }

    @PostMapping("/{reviewId}/likes")
    public ResponseEntity<Void> likeReview(
            @PathVariable Long reviewId,
            @AuthenticatedUser AuthUser user
    ) {
        reviewApplication.likeReview(reviewId, user.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
