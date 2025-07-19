package com.dragonsky.nextpage.domain.review.converter;

import com.dragonsky.nextpage.application.review.dto.request.CreateReviewInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    // TODO member 엔티티를 넣어야함
    public Review toEntity(CreateReviewInput input, Member member) {
        return Review.builder()
                .author(member)
                .title(input.title())
                .content(input.content())
                .rating(input.rating())
                .isPrivate(input.isPrivate())
                .build();
    }
}
