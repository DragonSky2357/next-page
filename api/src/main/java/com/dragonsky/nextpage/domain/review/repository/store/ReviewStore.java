package com.dragonsky.nextpage.domain.review.repository.store;

import com.dragonsky.nextpage.domain.review.entity.Review;

public interface ReviewStore {
    Review append(Review review); // 리뷰 등록

    void remove(Review review); // 리뷰 삭제

    void toogleLike(Long reviewId, Long memberId); // 좋아요 추가
}
