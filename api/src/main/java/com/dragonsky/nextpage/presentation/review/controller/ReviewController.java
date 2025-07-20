package com.dragonsky.nextpage.presentation.review.controller;

import com.dragonsky.nextpage.application.review.ReviewApplication;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.domain.auth.annotation.AuthenticatedUser;
import com.dragonsky.nextpage.presentation.review.converter.ReviewPersentationConverter;
import com.dragonsky.nextpage.presentation.review.dto.request.CreateReviewRequest;
import com.dragonsky.nextpage.presentation.review.dto.response.CreateReviewApiResponse;
import com.dragonsky.nextpage.presentation.review.dto.response.ReviewDetailApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewPersentationConverter reviewConverter;
    private final ReviewApplication reviewApplication;

    @PostMapping
    public ResponseEntity<CreateReviewApiResponse> createReview(@Valid @RequestBody CreateReviewRequest request,
                                                                @AuthenticatedUser AuthUser user) {
        var input = reviewConverter.fromRequest(request, user);
        var response = reviewApplication.createReview(input);
        var apiResponse = reviewConverter.toApiResponse(response);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDetailApiResponse> getReview(@PathVariable Long id) {
        var response = reviewApplication.getReview(id);
        var apiResponse = reviewConverter.toDetailApiResponse(response);
        return ResponseEntity.ok(apiResponse);
    }
}
