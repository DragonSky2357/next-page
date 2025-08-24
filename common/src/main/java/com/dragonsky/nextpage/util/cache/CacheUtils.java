package com.dragonsky.nextpage.util.cache;

import io.micrometer.common.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.Normalizer;

public class CacheUtils {

    public static String normalize(String query) {
        if (StringUtils.isBlank(query)) {
            return "";
        }

        // 1. 앞뒤 공백 제거, 소문자 변환
        String result = query.trim().toLowerCase();

        // 2. 연속 공백 → 단일 공백
        result = result.replaceAll("\\s+", " ");

        // 3. 특수문자 제거 (한글/영문/숫자/공백만 남기기)
        result = result.replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}\\s]", "");

        // 4. Unicode 정규화
        result = Normalizer.normalize(result, Normalizer.Form.NFC);

        return result;
    }

    /**
     * 캐시용 키 생성 (해시 포함)
     */
    public static String toCacheKey(String input) {
        String normalized = normalize(input);
        return DigestUtils.md5Hex(normalized);
    }
}
