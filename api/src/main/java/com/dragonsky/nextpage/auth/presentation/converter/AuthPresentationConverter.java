package com.dragonsky.nextpage.auth.presentation.converter;

import com.dragonsky.nextpage.auth.application.dto.input.LoginInput;
import com.dragonsky.nextpage.auth.application.dto.response.LoginResponse;
import com.dragonsky.nextpage.auth.presentation.dto.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthPresentationConverter {

    public LoginInput fromRequest(LoginRequest request){
        return new LoginInput(request.email(), request.password());
    }

    public LoginResponse toResponse(String accessToken, String refreshToken) {
        return new LoginResponse(accessToken, refreshToken);
    }
}
