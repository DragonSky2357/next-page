package com.dragonsky.nextpage.util.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    /**
     * 콤마(,)를 기준으로 문자열을 나눠 List<String>으로 반환
     * null이나 빈 문자열이면 빈 리스트 반환
     */
    public static List<String> splitByComma(String input) {
        if (input == null || input.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)        // 공백 제거
                .filter(s -> !s.isEmpty()) // 빈 문자열 제거
                .collect(Collectors.toList());
    }
}
