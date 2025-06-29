package com.dragonsky.nextpage.member.domain.service;

import com.dragonsky.nextpage.member.presentation.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.member.domain.entity.Member;

public interface MemberService {
    Member register(MemberRegistrationRequest request);
}
