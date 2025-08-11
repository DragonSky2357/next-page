package com.dragonsky.nextpage.exception;

import lombok.Getter;

@Getter
public class FieldError {
    private final String field;
    private final String message;

    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
