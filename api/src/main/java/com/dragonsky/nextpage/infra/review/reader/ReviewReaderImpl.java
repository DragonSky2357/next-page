package com.dragonsky.nextpage.infra.review.reader;

import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.repository.reader.ReviewReader;
import com.dragonsky.nextpage.domain.review.vo.ReviewDetail;
import com.dragonsky.nextpage.infra.review.jpa.ReviewJpaRepository;
import com.dragonsky.nextpage.infra.review.mybatis.mapper.ReviewMapper;
import com.dragonsky.nextpage.presentation.review.dto.request.ReviewSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewReaderImpl implements ReviewReader {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public Optional<Review> read(Long reviewId) {
        return reviewJpaRepository.findById(reviewId);
    }

    @Override
    public List<ReviewDetail> read(ReviewSearchCondition condition) {
        return reviewMapper.searchReviews(condition);
    }

    @Override
    public long count(ReviewSearchCondition condition) {
        return reviewMapper.countReviews(condition);
    }

    @Override
    public List<ReviewDetail> readAllWithDetails() {
        return List.of();
    }

    @Override
    public List<Review> readByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Review> search(String keyword) {
        return List.of();
    }
}
