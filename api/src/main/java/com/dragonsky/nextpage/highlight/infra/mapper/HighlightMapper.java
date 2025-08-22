package com.dragonsky.nextpage.highlight.infra.mapper;

import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchFilter;
import com.dragonsky.nextpage.highlight.infra.dto.response.GetHighlightsDto;
import com.dragonsky.nextpage.review.domain.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HighlightMapper {
    List<GetHighlightsDto> searchReviews(HighlightSearchFilter filter);
    int countReviews(HighlightSearchFilter filter);
}
