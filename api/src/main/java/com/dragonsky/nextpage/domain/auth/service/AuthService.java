package com.dragonsky.nextpage.domain.auth.service;

import com.dragonsky.nextpage.application.auth.dto.response.LoginResult;
import com.dragonsky.nextpage.domain.member.entity.Member;

public interface AuthService {
    LoginResult login(Member member, String rawPassword);
}
