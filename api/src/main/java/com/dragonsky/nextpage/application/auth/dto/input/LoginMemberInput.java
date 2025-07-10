package com.dragonsky.nextpage.application.auth.dto.input;

public record LoginMemberInput(
        Long memberId,
        String email
) {}
