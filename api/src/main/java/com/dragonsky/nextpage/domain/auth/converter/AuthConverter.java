package com.dragonsky.nextpage.domain.auth.converter;

import com.dragonsky.nextpage.application.auth.dto.response.LoginResponse;
import com.dragonsky.nextpage.application.auth.dto.response.LoginResult;
import org.springframework.stereotype.Component;

@Component
public class AuthConverter {

    public LoginResult toResult(String accessToken, String refreshToken){
        return new LoginResult(accessToken,refreshToken);
    }

}
