package com.dragonsky.nextpage.review.domain.factory;

import com.dragonsky.nextpage.review.application.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.review.domain.entity.Review;
import com.dragonsky.nextpage.review.domain.model.category.Category;
import com.dragonsky.nextpage.review.domain.model.status.Status;
import com.dragonsky.nextpage.review.domain.model.tag.Tag;
import com.dragonsky.nextpage.exception.FieldError;
import com.dragonsky.nextpage.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewFactory {

    public Review create(CreateReviewInput input, Member member, Book book) {
        validateInput(input);

        return Review.builder()
                .author(member)
                .book(book)
                .title(input.title())
                .content(input.content())
                .rating(input.rating())
                .status(Status.valueOf(input.status()))
                .category(Category.valueOf(input.category()))
                .tag(Tag.valueOf(input.tag()))
                .isPrivate(input.isPrivate())
                .build();
    }

    private void validateInput(CreateReviewInput input) {

        List<FieldError> errors = new ArrayList<>();

        if (input.title() == null || input.title().isBlank()) {
            errors.add(new FieldError("title", "제목은 필수 입력 항목입니다."));
        } else if (input.title().length() > 50) {
            errors.add(new FieldError("title", "제목은 50자 이내로 입력해야 합니다."));
        }

        if (input.content() != null && input.content().isBlank()) {
            errors.add(new FieldError("content", "내용이 빈 문자열입니다."));
        }

        if (input.rating() == null) {
            errors.add(new FieldError("rating", "평점은 필수 입력 항목입니다."));
        } else if (input.rating() < 0) {
            errors.add(new FieldError("rating", "평점은 0 이상이어야 합니다."));
        }

        if (input.isPrivate() == null) {
            errors.add(new FieldError("isPrivate", "비공개 여부는 필수 입력 항목입니다."));
        }

        if (input.status() == null) {
            errors.add(new FieldError("statusCode", "상태 코드는 필수 입력 항목입니다."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}