package com.dragonsky.nextpage.auth.domain.service;

import com.dragonsky.nextpage.auth.application.dto.response.LoginResult;
import com.dragonsky.nextpage.member.domain.entity.Member;

public interface AuthService {
    LoginResult login(Member member, String rawPassword);
}
