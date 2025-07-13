package com.dragonsky.nextpage.presentation.auth.converter;

import com.dragonsky.nextpage.application.auth.dto.input.LoginInput;
import com.dragonsky.nextpage.application.auth.dto.response.LoginResponse;
import com.dragonsky.nextpage.presentation.auth.dto.LoginRequest;
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
