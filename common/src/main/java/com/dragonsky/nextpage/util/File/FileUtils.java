package com.dragonsky.nextpage.util.File;

public class FileUtils {

    /**
     * 파일명에서 확장자를 추출
     *
     * @param filename 원본 파일명
     * @return 확장자(.포함), 없으면 빈 문자열
     */
    public static String getExtension(String filename) {
        if (filename == null || filename.isBlank()) {
            return "";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex); // .png, .jpg 등
        }
        return "";
    }
}
