package com.dragonsky.nextpage.presentation.auth.converter;

import com.dragonsky.nextpage.application.auth.dto.input.LoginInput;
import com.dragonsky.nextpage.presentation.auth.dto.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthApplicationConverter {

    public LoginInput fromRequest(LoginRequest request){
        return new LoginInput(request.email(), request.password());
    }

}
