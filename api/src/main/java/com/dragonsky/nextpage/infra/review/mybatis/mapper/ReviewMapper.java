package com.dragonsky.nextpage.infra.review.mybatis.mapper;

import com.dragonsky.nextpage.domain.review.dto.response.GetReviewsDto;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<GetReviewsDto> searchReviews(ReviewSearchCondition condition);

    int countReviews(ReviewSearchCondition condition);
}
