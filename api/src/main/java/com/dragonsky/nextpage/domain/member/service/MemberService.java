package com.dragonsky.nextpage.domain.member.service;

import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.domain.member.entity.Member;

public interface MemberService {
    Long register(MemberRegistrationInput input);
    Member getMemberByEmail(String email);
    Member getMemberById(Long memberId);
}
