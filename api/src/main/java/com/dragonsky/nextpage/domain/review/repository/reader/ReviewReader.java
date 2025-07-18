package com.dragonsky.nextpage.domain.review.repository.reader;

import com.dragonsky.nextpage.domain.review.dto.ReviewDetail;
import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReviewReader {
    Optional<Review> findById(Long id);
    Page<Review> findAll(Pageable pageable);
    List<ReviewDetail> findAllWithDetails();
    List<Review> findByTitle(String title);
    List<Review> searchByKeyword(String keyword);
}