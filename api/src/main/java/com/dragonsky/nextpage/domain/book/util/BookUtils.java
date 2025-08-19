package com.dragonsky.nextpage.domain.book.util;

public class BookUtils {

    private BookUtils() {
    }

    /**
     * ISBN 정규화
     * - 하이픈 제거
     * - 공백 제거
     * - 필요 시 대문자 통일
     */
    public static String normalize(String isbn) {
        if (isbn == null) return null;
        return isbn.replaceAll("-", "").trim();
    }
}
