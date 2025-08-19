package com.dragonsky.nextpage.auth.domain.converter;

import com.dragonsky.nextpage.auth.application.dto.response.LoginResult;
import org.springframework.stereotype.Component;

@Component
public class AuthConverter {

    public LoginResult toResult(String accessToken, String refreshToken){
        return new LoginResult(accessToken,refreshToken);
    }

}
