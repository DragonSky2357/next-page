package com.dragonsky.nextpage.presentation.member.converter;

import com.dragonsky.nextpage.application.member.dto.response.MemberRegistrationResponse;
import com.dragonsky.nextpage.presentation.member.dto.response.MemberRegistrationApiResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberApplicationConverter {

    public MemberRegistrationApiResponse toApiResponse(MemberRegistrationResponse response) {
        return new MemberRegistrationApiResponse(
                response.memberId()
        );
    }
}
