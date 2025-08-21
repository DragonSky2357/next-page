package com.dragonsky.nextpage.util.File.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImagesValidator.class)
public @interface Images {
    String message() default "허용되지 않는 이미지 형식 또는 개수 초과";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] allowedExtensions() default { "jpg", "jpeg", "png", "gif", "webp" };
    long maxSize() default 10 * 1024 * 1024; // 10MB
    int maxCount() default 3;
}
