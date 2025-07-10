package com.dragonsky.nextpage.domain.member.converter;

import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter {

    public Member toEntity(MemberRegistrationInput input, String encodedPassword) {
        return Member.builder()
                .email(input.email())
                .password(encodedPassword)
                .nickname(input.nickname())
                .build();
    }
}
