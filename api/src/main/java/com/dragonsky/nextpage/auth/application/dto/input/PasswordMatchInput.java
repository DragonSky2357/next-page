package com.dragonsky.nextpage.auth.application.dto.input;

public record PasswordMatchInput(
        String password,
        String rawPassword
) {}
