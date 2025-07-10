package com.dragonsky.nextpage.application.member;

import com.dragonsky.nextpage.application.member.converter.MemberApplicationConverter;
import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.domain.member.service.MemberService;
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
    private final MemberApplicationConverter memberConverter;

    public MemberRegistrationResponse register(MemberRegistrationInput memberRegistrationInput) {
        Long memberId = memberService.register(memberRegistrationInput);
        return memberConverter.toResponse(memberId);
    }
}
