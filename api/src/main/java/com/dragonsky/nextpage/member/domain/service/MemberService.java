package com.dragonsky.nextpage.member.domain.service;

import com.dragonsky.nextpage.member.application.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.member.domain.entity.Member;

public interface MemberService {
    Long register(MemberRegistrationInput input);
    Member getMemberByEmail(String email);
    Member getMemberById(Long memberId);
}
