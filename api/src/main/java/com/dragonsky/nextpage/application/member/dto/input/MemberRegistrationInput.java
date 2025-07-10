package com.dragonsky.nextpage.application.member.dto.input;

public record MemberRegistrationInput(
        String email,
        String password,
        String nickname
) {}
