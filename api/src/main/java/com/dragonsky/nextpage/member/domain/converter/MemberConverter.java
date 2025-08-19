package com.dragonsky.nextpage.member.domain.converter;

import com.dragonsky.nextpage.member.application.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.member.domain.entity.Member;
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
