package com.dragonsky.nextpage.review.application;

import com.dragonsky.nextpage.review.application.converter.ReviewApplicationConverter;
import com.dragonsky.nextpage.review.application.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.review.application.dto.request.ModifyReviewInput;
import com.dragonsky.nextpage.review.application.dto.request.RemoveReviewInput;
import com.dragonsky.nextpage.review.application.dto.response.CreateReviewResult;
import com.dragonsky.nextpage.review.application.dto.response.GetReviewResult;
import com.dragonsky.nextpage.review.application.dto.response.GetReviewsResult;
import com.dragonsky.nextpage.book.domain.service.BookService;
import com.dragonsky.nextpage.member.domain.service.MemberService;
import com.dragonsky.nextpage.review.domain.service.ReviewService;
import com.dragonsky.nextpage.review.presentation.dto.request.ReviewSearchCondition;
import com.dragonsky.nextpage.response.PageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ReviewApplication {

    private final ReviewApplicationConverter reviewConverter;
    private final ReviewService reviewService;
    private final MemberService memberService;
    private final BookService bookService;

    @Transactional
    public CreateReviewResult createReview(CreateReviewInput input) {
        var member = memberService.getMemberById(input.authorId());

        var book = bookService.getBookByIsbn(input.isbn());

        var saveBook = bookService.createBook(book);

        var reviewId = reviewService.createReview(input, member, saveBook);

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

