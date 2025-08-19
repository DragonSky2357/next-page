package com.dragonsky.nextpage.member.application;

import com.dragonsky.nextpage.member.application.converter.MemberApplicationConverter;
import com.dragonsky.nextpage.member.application.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.member.application.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.member.domain.service.MemberService;
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

    @Transactional
    public MemberRegistrationResponse register(MemberRegistrationInput memberRegistrationInput) {
        Long memberId = memberService.register(memberRegistrationInput);
        return memberConverter.toResponse(memberId);
    }
}
