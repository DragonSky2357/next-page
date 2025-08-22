package com.dragonsky.nextpage.highlight.infra.reader;

import com.dragonsky.nextpage.highlight.application.dto.input.HighlightSearchFilter;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.highlight.domain.exception.HighlightErrorCode;
import com.dragonsky.nextpage.highlight.domain.exception.HighlightException;
import com.dragonsky.nextpage.highlight.domain.repository.reader.HightlightReader;
import com.dragonsky.nextpage.highlight.infra.dto.response.GetHighlightsDto;
import com.dragonsky.nextpage.highlight.infra.jpa.HighlightJpaRepository;
import com.dragonsky.nextpage.highlight.infra.mapper.HighlightMapper;
import com.dragonsky.nextpage.review.domain.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.review.domain.entity.Review;
import com.dragonsky.nextpage.review.domain.repository.reader.ReviewReader;
import com.dragonsky.nextpage.review.domain.vo.ReviewDetail;
import com.dragonsky.nextpage.review.infra.jpa.ReviewJpaRepository;
import com.dragonsky.nextpage.review.infra.mybatis.mapper.ReviewMapper;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HightlightReaderImpl implements HightlightReader {

    private final HighlightJpaRepository highlightJpaRepository;
    private final HighlightMapper highlightMapper;

    @Override
    public Optional<Highlight> read(Long hightlightId) {
        return highlightJpaRepository.findById(hightlightId);
    }

    // TODO CURD 이후에 작업
    @Override
    public List<GetHighlightsDto> readGetHighlightsDtoList(HighlightSearchFilter filter) {
        return List.of();
    }
}
