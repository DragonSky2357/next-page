package com.dragonsky.nextpage.presentation.auth.controller;

import com.dragonsky.nextpage.application.auth.AuthApplication;
import com.dragonsky.nextpage.presentation.auth.converter.AuthPresentationConverter;
import com.dragonsky.nextpage.presentation.auth.dto.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthApplication authApplication;
    private final AuthPresentationConverter authConverter;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request, HttpServletResponse httpServletResponse) {
        var loginInput = authConverter.fromRequest(request);
        var response = authApplication.login(loginInput);

        Cookie accessTokenCookie = new Cookie("ACCESS_TOKEN", response.accessToken());
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setSecure(true);
        // https 적용시
        // accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(60 * 15);
        httpServletResponse.addCookie(accessTokenCookie);

        Cookie refreshTokenCookie = new Cookie("REFRESH_TOKEN", response.refreshToken());
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setSecure(true);
        // https 적용시
        // accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(60 * 60 * 24 * 7);
        httpServletResponse.addCookie(refreshTokenCookie);

        return ResponseEntity.noContent().build();
    }
}
