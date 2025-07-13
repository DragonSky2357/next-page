package com.dragonsky.nextpage.application.auth;

import com.dragonsky.nextpage.application.auth.dto.input.LoginInput;
import com.dragonsky.nextpage.application.auth.dto.response.LoginResponse;
import com.dragonsky.nextpage.domain.auth.service.AuthService;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.presentation.auth.converter.AuthPresentationConverter;
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

        // TODO redis에 refresh token 넣어야함
        return authConverter.toResponse(loginResult.accessToken(), loginResult.refreshToken());
    }
}
