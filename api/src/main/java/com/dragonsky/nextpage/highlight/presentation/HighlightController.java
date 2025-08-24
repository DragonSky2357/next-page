package com.dragonsky.nextpage.highlight.presentation;

import com.dragonsky.nextpage.auth.domain.annotation.AuthenticatedUser;
import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.highlight.application.HighlightApplication;
import com.dragonsky.nextpage.highlight.presentation.converter.HighlightConverter;
import com.dragonsky.nextpage.highlight.presentation.dto.request.CreateHighlightRequest;
import com.dragonsky.nextpage.highlight.presentation.dto.request.HighlightSearchRequest;
import com.dragonsky.nextpage.highlight.presentation.dto.response.CreateHighlightApiResponse;
import com.dragonsky.nextpage.highlight.presentation.dto.response.HighlightResponse;
import com.dragonsky.nextpage.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/highlights")
public class HighlightController {

    private final HighlightConverter converter;
    private final HighlightApplication application;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateHighlightApiResponse>> createHighlight(
            @AuthenticatedUser AuthUser user,
            @Valid @RequestBody CreateHighlightRequest request
    ){
        var input = converter.fromRequest(user, request);
        var result = application.createHighlight(input);
        var response = converter.toResponse(result);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("하이라이트가 성공적으로 등록되었습니다.", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<HighlightResponse>> getHighlights(
            HighlightSearchRequest request
    ){
        var input = converter.fromRequest(request);
        var result = application.searchHighlights();
        var response = converter.toResponse();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{highlightId}")
    public ResponseEntity<ApiResponse<HighlightDetailResponse>> getHighlight(
            @PathVariable Long highlightId
    ){
        var result = application.getReview(highlightId);
        var response = converter.toResponse(result);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{highlightId}")
    public ResponseEntity<ApiResponse<Void>> modifyHighlight(
            @PathVariable Long highlightId,
            @AuthenticatedUser AuthUser user,
            @Valid @RequestBody ModifyHighlightRequest request
    ){
        var input = converter.fromRequest(highlightId, user, request);
        application.modifyHighlight(input);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("하이라이트가 성공적으로 수정되었습니다."));
    }

    @DeleteMapping("/{highlightId}")
    public ResponseEntity<ApiResponse<Void>> removeHighlight(
            @PathVariable Long reviewId,
            @AuthenticatedUser AuthUser user
    ){
        var input = converter.fromRequest(reviewId, user);
        application.removeHighlight(input);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success("하이라이트가 성공적으로 삭제되었습니다."));
    }
}
