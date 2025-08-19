package com.dragonsky.nextpage.member.application.dto.input;

public record MemberRegistrationInput(
        String email,
        String password,
        String nickname
) {}
