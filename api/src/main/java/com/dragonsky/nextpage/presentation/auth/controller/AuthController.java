package com.dragonsky.nextpage.presentation.auth.controller;

import com.dragonsky.nextpage.application.auth.AuthApplication;
import com.dragonsky.nextpage.presentation.auth.converter.AuthApplicationConverter;
import com.dragonsky.nextpage.presentation.auth.dto.LoginRequest;
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
    private final AuthApplicationConverter authConverter;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request) {
        var loginInput = authConverter.fromRequest(request);
        var response = authApplication.login(loginInput);
        var apiResponse = authConverter.toApiResponse(response);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + tokenDto.accessToken())
                .header("Refresh-Token", tokenDto.refreshToken())
                .header("Access-Token-Expire-Time", String.valueOf(tokenDto.expiresIn()))
                .build();
    }
}
