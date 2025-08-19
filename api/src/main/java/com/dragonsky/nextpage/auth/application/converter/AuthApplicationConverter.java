package com.dragonsky.nextpage.auth.application.converter;

import com.dragonsky.nextpage.auth.application.dto.response.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthApplicationConverter {

    public LoginResponse toResponse(String accessToken, String refreshToken) {
        return new LoginResponse(
                accessToken,
                refreshToken
        );
    }
}
