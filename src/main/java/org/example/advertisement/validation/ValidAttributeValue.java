package org.example.advertisement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.advertisement.validator.AttributeValueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка значения атрибута объявления.
 * Проверяет, что значение не является объектом или массивом,
 * не превышает maxLength и не содержит отрицательных чисел.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AttributeValueValidator.class)
public @interface ValidAttributeValue {
    String message() default "Некорректное значение атрибута";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int maxLength() default 1000;
}