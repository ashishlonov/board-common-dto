package org.example.photo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.photo.validator.ImageFileValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFileValidator.class)
public @interface ValidImageFile {
    String message() default "Некорректный файл";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    long maxSizeBytes() default 10 * 1024 * 1024;
}