package com.dragonsky.nextpage.domain.member.service;

import com.dragonsky.nextpage.application.member.dto.request.MemberRegistrationDto;

public interface MemberService {
    Long register(MemberRegistrationDto dto);
}
