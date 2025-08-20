package com.dragonsky.nextpage.util.File.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class ImagesValidator implements ConstraintValidator<Images, List<MultipartFile>> {

    private String[] allowedExtensions;
    private long maxSize;
    private int maxCount;

    @Override
    public void initialize(Images annotation) {
        this.allowedExtensions = annotation.allowedExtensions();
        this.maxSize = annotation.maxSize();
        this.maxCount = annotation.maxCount();
    }

    @Override
    public boolean isValid(List<MultipartFile> files, ConstraintValidatorContext context) {
        if (files == null || files.isEmpty()) {
            return true; // 파일이 없어도 허용
        }

        if (files.size() > maxCount) {
            return false;
        }

        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) return false;
            if (file.getSize() > maxSize) return false;

            String filename = file.getOriginalFilename();
            if (filename == null || !filename.contains(".")) return false;

            String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
            if (!Arrays.asList(allowedExtensions).contains(extension)) return false;
        }

        return true;
    }
}
