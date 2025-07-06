package com.dragonsky.nextpage.application.member.dto.request;

public record MemberRegistrationDto(
        String email,
        String password,
        String nickname
) {}
