package com.dragonsky.nextpage.apiresponse;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private String code;        // 응답 코드
    private String message;     // 응답 메시지
    private T data;             // 실제 데이터
    private LocalDateTime timestamp; // 응답 시간

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("SUCCESS", null, data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("SUCCESS", message, data);
    }

    public static <T> ApiResponse<T> fail(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}