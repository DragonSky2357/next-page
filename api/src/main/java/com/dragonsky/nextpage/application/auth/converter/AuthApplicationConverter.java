package com.dragonsky.nextpage.application.auth.converter;

import com.dragonsky.nextpage.application.auth.dto.response.LoginResponse;
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
