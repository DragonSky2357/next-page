package com.dragonsky.nextpage.auth.application;

import com.dragonsky.nextpage.auth.application.dto.input.LoginInput;
import com.dragonsky.nextpage.auth.application.dto.response.LoginResponse;
import com.dragonsky.nextpage.auth.domain.service.AuthService;
import com.dragonsky.nextpage.member.domain.entity.Member;
import com.dragonsky.nextpage.member.domain.service.MemberService;
import com.dragonsky.nextpage.auth.presentation.converter.AuthPresentationConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthApplication {

    private final AuthPresentationConverter authConverter;
    private final AuthService authService;
    private final MemberService memberService;

    public LoginResponse login(LoginInput loginInput) {
        Member member = memberService.getMemberByEmail(loginInput.email());

        var loginResult = authService.login(member, loginInput.password());

        return authConverter.toResponse(loginResult.accessToken(), loginResult.refreshToken());
    }
}
