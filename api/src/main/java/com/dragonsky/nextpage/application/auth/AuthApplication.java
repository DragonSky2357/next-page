package com.dragonsky.nextpage.application.auth;

import com.dragonsky.nextpage.application.auth.converter.AuthConverter;
import com.dragonsky.nextpage.application.auth.dto.input.LoginInput;
import com.dragonsky.nextpage.application.auth.dto.input.LoginMemberInput;
import com.dragonsky.nextpage.application.auth.dto.response.LoginResponse;
import com.dragonsky.nextpage.config.security.JwtTokenProvider;
import com.dragonsky.nextpage.domain.auth.exception.AuthException;
import com.dragonsky.nextpage.domain.auth.service.AuthService;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.service.MemberService;
import com.dragonsky.nextpage.util.security.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.dragonsky.nextpage.domain.auth.exception.AuthErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthApplication {

    private final AuthConverter authConverter;
    private final AuthService authService;
    private final MemberService memberService;
    private final PasswordEncoderUtil passwordEncoderUtil;
    private final JwtTokenProvider jwtTokenProvider;


    public LoginResponse login(LoginInput loginInput) {
        Member member = memberService.getMemberByEmail(loginInput.email());

        var loginMemberInput = new LoginMemberInput(member.getId(), member.getEmail());

        authService.login(loginMemberInput);
        
        if (!passwordEncoderUtil.matches(loginInput.password(), member.getPassword())) {
            throw new AuthException(PASSWORD_NOT_MATCHED);
        }
        
        
        String accessToken = jwtTokenProvider.createAccessToken(member.getId(), member.getEmail());
        String refreshToken = jwtTokenProvider.createRefreshToken(member.getId(), member.getEmail());

        // TODO redis에 refresh token 넣어야함
        return authConverter.toResponse(accessToken, refreshToken);
    }
}
