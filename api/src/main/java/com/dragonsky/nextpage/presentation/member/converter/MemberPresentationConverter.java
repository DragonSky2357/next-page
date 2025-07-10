package com.dragonsky.nextpage.presentation.member.converter;

import com.dragonsky.nextpage.application.member.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.presentation.member.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.presentation.member.dto.response.MemberRegistrationApiResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberPresentationConverter{

    public MemberRegistrationApiResponse toApiResponse(MemberRegistrationResponse response) {
        return new MemberRegistrationApiResponse(
                response.memberId()
        );
    }

    public MemberRegistrationInput fromRequest(MemberRegistrationRequest request) {
        return new MemberRegistrationInput(
                request.email(),
                request.password(),
                request.nickname()
        );
    }
}
