package org.example.photo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.photo.validator.ImageFilesValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFilesValidator.class)
public @interface ValidImageFiles {
    String message() default "Некорректные файлы";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int maxCount() default 10;
    long maxSizeBytes() default 10 * 1024 * 1024;
}