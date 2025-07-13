package com.dragonsky.nextpage.application.auth.dto.input;

public record PasswordMatchInput(
        String password,
        String rawPassword
) {}
