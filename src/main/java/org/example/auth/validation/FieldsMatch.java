package org.example.auth.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.auth.validator.FieldsMatchValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка совпадения двух полей на уровне класса.
 * Параметр shouldMatch управляет проверкой: true — поля должны совпадать,
 * false — поля не должны совпадать (например, старый и новый пароль).
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatch {
    String field();
    String fieldMatch();
    String message() default "Поля {field} и {fieldMatch} должны совпадать";
    boolean shouldMatch() default true;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
