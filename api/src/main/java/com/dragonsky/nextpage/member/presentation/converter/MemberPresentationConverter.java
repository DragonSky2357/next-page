package com.dragonsky.nextpage.member.presentation.converter;

import com.dragonsky.nextpage.member.application.dto.input.MemberRegistrationInput;
import com.dragonsky.nextpage.member.application.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.member.presentation.dto.request.MemberRegistrationRequest;
import com.dragonsky.nextpage.member.presentation.dto.response.MemberRegistrationApiResponse;
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
