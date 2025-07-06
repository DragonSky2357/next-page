package com.dragonsky.nextpage.application.member;

import com.dragonsky.nextpage.application.member.converter.MemberPresentationConverter;
import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.presentation.member.dto.request.MemberRegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberApplication {
    private final MemberService memberService;
    private final MemberPresentationConverter memberConverter;

    public MemberRegistrationResponse register(MemberRegistrationRequest request) {
        var memberRegistraionDto = memberConverter.toMemberRegistrationDto(request);
        Long memberId = memberService.register(memberRegistraionDto);

        return memberConverter.toResponse(memberId);
    }
}
