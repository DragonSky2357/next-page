package com.dragonsky.nextpage.application.member.converter;

import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberApplicationConverter {

    public Member toEntity(MemberRegistrationInput input) {
        return Member.builder()
                .email(input.email())
                .password(input.password())
                .nickname(input.nickname())
                .build();
    }

    public MemberRegistrationResponse toResponse(Long memberId) {
        return MemberRegistrationResponse.builder()
                .memberId(memberId)
                .build();
    }
}
