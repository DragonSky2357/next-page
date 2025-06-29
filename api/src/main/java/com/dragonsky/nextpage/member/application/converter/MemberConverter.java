package com.dragonsky.nextpage.member.application.converter;

import com.dragonsky.nextpage.member.presentation.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.util.security.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberConverter {

    private final PasswordEncoderUtil passwordEncoderUtil;

    public Member toEntity(MemberRegistrationRequest request) {
        return Member.builder()
                .email(request.email())
                .password(passwordEncoderUtil.encode(request.password()))
                .nickname(request.nickname())
                .build();
    }
}
