package com.dragonsky.nextpage.review.infra.mybatis.mapper;

import com.dragonsky.nextpage.review.domain.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<GetReviewsDto> searchReviews(ReviewSearchCondition condition);

    int countReviews(ReviewSearchCondition condition);
}
