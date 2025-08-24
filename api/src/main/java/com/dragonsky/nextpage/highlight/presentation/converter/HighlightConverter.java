package com.dragonsky.nextpage.highlight.presentation.converter;

import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.highlight.application.dto.input.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchInput;
import com.dragonsky.nextpage.highlight.application.dto.result.CreateHighlightResult;
import com.dragonsky.nextpage.highlight.presentation.dto.request.CreateHighlightRequest;
import com.dragonsky.nextpage.highlight.presentation.dto.request.HighlightSearchRequest;
import com.dragonsky.nextpage.highlight.presentation.dto.response.CreateHighlightApiResponse;
import jakarta.validation.Valid;

public class HighlightConverter {
    public CreateHighlightInput fromRequest(AuthUser user, @Valid CreateHighlightRequest request) {
        return null;
    }

    public CreateHighlightApiResponse toResponse(CreateHighlightResult result) {
        return null;
    }

    public HighlightSearchInput fromRequest(HighlightSearchRequest request) {
        return null;
    }

    public HighlightSearchApiResponse toResponse(HighlightSearchResult result) {
        return null;
    }
}
