package com.dragonsky.nextpage.domain.review.service;

public interface ReviewLikeService {

    /**
     * 특정 리뷰에 대해 회원이 좋아요를 등록합니다.
     *
     * @param reviewId 좋아요 대상 리뷰의 ID
     * @param memberId 좋아요를 누른 회원의 ID
     */
    void likeReview(Long reviewId, Long memberId);

    /**
     * 특정 리뷰에 대해 회원이 좋아요를 취소합니다.
     *
     * @param reviewId 좋아요 취소 대상 리뷰의 ID
     * @param memberId 좋아요를 취소한 회원의 ID
     */
    void unlikeReview(Long reviewId, Long memberId);

    /**
     * 특정 리뷰의 현재 좋아요 수를 조회합니다.
     *
     * @param reviewId 좋아요 수를 조회할 리뷰의 ID
     * @return 해당 리뷰의 좋아요 개수
     */
    int getLikesCount(Long reviewId);

    /**
     * 특정 회원이 특정 리뷰에 좋아요를 눌렀는지 여부를 확인합니다.
     *
     * @param reviewId 리뷰의 ID
     * @param memberId 회원의 ID
     * @return 좋아요를 눌렀으면 true, 아니면 false
     */
    boolean hasLiked(Long reviewId, Long memberId);
}

