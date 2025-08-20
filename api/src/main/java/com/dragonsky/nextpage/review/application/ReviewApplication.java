package com.dragonsky.nextpage.review.application;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.book.domain.service.BookService;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.member.domain.service.MemberService;
import com.dragonsky.nextpage.response.PageResult;
import com.dragonsky.nextpage.review.application.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.review.application.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.review.application.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.review.application.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.review.application.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.review.application.dto.response.GetReviewResult;
import com.dragonsky.nextpage.review.application.dto.response.GetReviewsResult;
import com.dragonsky.nextpage.review.domain.service.ReviewService;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;
import com.dragonsky.nextpage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewApplication {

    private final ReviewApplicationConverter reviewConverter;
    private final ReviewService reviewService;
    private final MemberService memberService;
    private final BookService bookService;
    private final ImageService imageService;


    @Transactional
    public CreateReviewResult createReview(CreateReviewInput input) {
        // 1. 작성자 조회
        Member member = memberService.getMemberById(input.authorId());

        // 2. 책 조회 및 저장
        Book book = bookService.createBook(bookService.getBookByIsbn(input.isbn()));

        // 3. 리뷰 생성
        Long reviewId = reviewService.createReview(input, member, book);

        // 4. 이미지 업로드 + DB 저장 (빈 리스트 처리 포함)
        Optional.ofNullable(input.images())
                .map(file -> imageService.uploadImages(file, "review", reviewId));

        return reviewConverter.toCreateReviewResponse(reviewId);
    }

    public GetReviewResult getReview(Long reviewId) {
        var review = reviewService.getReview(reviewId);

        return reviewConverter.toResult(review);
    }

    public PageResult<GetReviewsResult> getReviews(ReviewSearchCondition condition) {
        var reviews = reviewService.getReviews(condition);

        return reviewConverter.toResult(reviews);
    }

    @Transactional
    public void modifyReview(ModifyReviewInput input) {
        var member = memberService.getMemberById(input.userId());

        reviewService.modifyReview(member, input);
    }

    @Transactional
    public void removeReview(RemoveReviewInput input) {
        var member = memberService.getMemberById(input.userId());

        reviewService.removeReview(member, input);
    }

    public void likeReview(Long reviewId, Long memberId) {
        var member = memberService.getMemberById(memberId);

        reviewService.likeReview(reviewId, member.getId());
    }
}

