package com.dragonsky.nextpage.util.File.validation;

import com.dragonsky.nextpage.util.File.FileUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {

    private String[] allowedExtensions;
    private long maxSize;

    @Override
    public void initialize(Image annotation) {
        this.allowedExtensions = annotation.allowedExtensions();
        this.maxSize = annotation.maxSize();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) return true;

        if (file.getSize() > maxSize) return false;

        String ext = FileUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        return Arrays.asList(allowedExtensions).contains(ext);
    }
}
