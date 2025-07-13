package com.dragonsky.nextpage.domain.auth.service.impl;

import com.dragonsky.nextpage.application.auth.dto.response.LoginResult;
import com.dragonsky.nextpage.config.security.JwtTokenProvider;
import com.dragonsky.nextpage.domain.auth.converter.AuthConverter;
import com.dragonsky.nextpage.domain.auth.exception.AuthException;
import com.dragonsky.nextpage.domain.auth.repository.reader.AuthReader;
import com.dragonsky.nextpage.domain.auth.repository.store.AuthStore;
import com.dragonsky.nextpage.domain.auth.service.AuthService;
import com.dragonsky.nextpage.domain.auth.vo.RefreshToken;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.util.security.PasswordEncoderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.dragonsky.nextpage.domain.auth.exception.AuthErrorCode.PASSWORD_NOT_MATCHED;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final AuthConverter authConverter;
    private final AuthStore authStore;
    private final AuthReader authReader;
    private final PasswordEncoderUtil passwordEncoderUtil;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResult login(Member member, String rawPassword) {
        if (!passwordEncoderUtil.matches(rawPassword, member.getPassword())) {
            throw new AuthException(PASSWORD_NOT_MATCHED);
        }

        String accessToken = jwtTokenProvider.createAccessToken(member.getId(), member.getEmail());
        String refreshToken = jwtTokenProvider.createRefreshToken(member.getId(), member.getEmail());

        authStore.saveRefreshToken(member.getId(), new RefreshToken(refreshToken));
        return authConverter.toResult(accessToken, refreshToken);
    }
}
