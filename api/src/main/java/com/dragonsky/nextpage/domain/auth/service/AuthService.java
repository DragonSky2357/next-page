package com.dragonsky.nextpage.domain.auth.service;

import com.dragonsky.nextpage.application.auth.dto.input.LoginMemberInput;

public interface AuthService {
    void login(LoginMemberInput input);
}
