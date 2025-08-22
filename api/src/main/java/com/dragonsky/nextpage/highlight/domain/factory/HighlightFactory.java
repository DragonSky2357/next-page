package com.dragonsky.nextpage.highlight.domain.factory;

import com.dragonsky.nextpage.book.domain.entity.Book;
import com.dragonsky.nextpage.exception.FieldError;
import com.dragonsky.nextpage.exception.ValidationException;
import com.dragonsky.nextpage.highlight.application.dto.request.CreateHighlightInput;
import com.dragonsky.nextpage.highlight.domain.entity.Highlight;
import com.dragonsky.nextpage.member.domain.entity.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HighlightFactory {

    private static final int MAX_TAG_COUNT = 5;

    public Highlight create(Book book, Member member, CreateHighlightInput input) {
        validateInput(input);

        return Highlight.builder()
                .book(book)
                .member(member)
                .content(input.content().trim())
                .page(input.page())
//              .tags(input.tags()) TODO Tag 생성이후 확인 필요
                .build();
    }

    private void validateInput(CreateHighlightInput input) {
        List<FieldError> errors = new ArrayList<>();

        // content 검증
        if (input.content() == null || input.content().isBlank()) {
            errors.add(new FieldError("content", "내용은 필수입니다."));
        }

        // page 검증
        if (input.page() == null) {
            errors.add(new FieldError("page", "페이지 번호는 필수입니다."));
        } else if (input.page() < 0) {
            errors.add(new FieldError("page", "페이지 번호는 0 이상이어야 합니다."));
        }

        // TODO Tag 생성이후 검증 필요
        // tags 검증
//        if (input.tags() != null) {
//            Set<String> tagSet = new HashSet<>(input.tags());
//            if (tagSet.size() > MAX_TAG_COUNT) {
//                errors.add(new FieldError("tags", "태그는 최대 5개까지 가능합니다."));
//            }
//            if (tagSet.size() != input.tags().size()) {
//                errors.add(new FieldError("tags", "중복된 태그는 허용되지 않습니다."));
//            }
//        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}

