package com.dragonsky.nextpage.infrastructure.review.reader;

import com.dragonsky.nextpage.domain.review.dto.ReviewDetail;
import com.dragonsky.nextpage.domain.review.entity.Review;
import com.dragonsky.nextpage.domain.review.repository.reader.ReviewReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReviewReaderImpl implements ReviewReader {
    @Override
    public Optional<Review> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ReviewDetail> findAllWithDetails() {
        return List.of();
    }

    @Override
    public List<Review> findByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Review> searchByKeyword(String keyword) {
        return List.of();
    }
}
