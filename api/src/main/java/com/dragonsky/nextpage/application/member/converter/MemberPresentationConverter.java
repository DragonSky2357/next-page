package com.dragonsky.nextpage.application.member.converter;

import com.dragonsky.nextpage.application.member.dto.request.MemberRegistrationDto;
import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.presentation.member.dto.request.MemberRegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class MemberPresentationConverter {

    public Member toEntity(MemberRegistrationDto dto) {
        return Member.builder()
                .email(dto.email())
                .password(dto.password())
                .nickname(dto.nickname())
                .build();
    }

    public MemberRegistrationDto toMemberRegistrationDto(MemberRegistrationRequest request) {
        return new MemberRegistrationDto(
                request.email(),
                request.password(),
                request.nickname()

        );
    }

    public MemberRegistrationResponse toResponse(Long memberId) {
        return MemberRegistrationResponse.builder()
                .memberId(memberId)
                .build();
    }
}
