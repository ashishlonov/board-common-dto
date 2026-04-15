package org.example.photo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.photo.validator.ImageFilesValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка списка загружаемых файлов изображений.
 * Список не должен быть пустым, количество файлов не больше maxCount (по умолчанию 10),
 * каждый файл не пустой и не больше maxSizeBytes (по умолчанию 10 МБ).
 */
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