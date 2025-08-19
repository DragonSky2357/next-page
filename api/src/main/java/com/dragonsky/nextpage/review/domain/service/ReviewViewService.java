package com.dragonsky.nextpage.review.domain.service;

public interface ReviewViewService {

    /**
     * 특정 리뷰의 조회수를 1 증가시킵니다.
     *
     * @param reviewId 조회수를 증가시킬 리뷰의 ID
     */
    void incrementViewCount(Long reviewId);

    /**
     * 특정 리뷰의 현재 조회수를 조회합니다.
     *
     * @param reviewId 조회수를 조회할 리뷰의 ID
     * @return 해당 리뷰의 조회수
     */
    int getViewCount(Long reviewId);
}

