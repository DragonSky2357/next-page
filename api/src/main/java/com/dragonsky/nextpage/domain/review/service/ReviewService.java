package com.dragonsky.nextpage.domain.review.service;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.application.review.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    /**
     * 리뷰를 생성합니다.
     *
     * @param input  리뷰 생성에 필요한 입력값
     * @param member
     * @return 생성된 리뷰의 ID
     */
    Long createReview(CreateReviewInput input, Member member);

    /**
     * 특정 리뷰를 조회합니다.
     * 이 메서드는 리뷰의 상세 정보를 반환합니다.
     * 리뷰가 존재하지 않을 경우 예외를 발생시킬 수 있습니다.
     *
     * @param reviewId 조회할 리뷰의 ID
     * @return 리뷰의 상세 정보
     */
    Review getReview(Long reviewId);

    /**
     * 전체 리뷰 목록을 조회합니다.
     * 페이징 처리로 확장 가능성이 있습니다.
     *
     * @return 리뷰 정보 리스트
     */

    Page<Review> getReviews(Pageable pageable);

    /**
     * 기존 리뷰를 수정합니다.
     * 현재는 전체 업데이트 적용 => 이후에 개별로 수정
     *
     * @param member 수정할 리뷰 작성자 권한 체크
     * @param input  수정에 필요한 입력값
     */
    void modifyReview(Member member, ModifyReviewInput input);

    /**
     * 리뷰를 삭제합니다.
     * 실제 삭제가 아닌 소프트 삭제 방식일 수 있습니다.
     *
     * @param member 수정할 리뷰 작성자 권한 체크
     * @param input  삭제에 필요한 입력값(reviewId)
     */
    void removeReview(Member member, RemoveReviewInput input);
}
