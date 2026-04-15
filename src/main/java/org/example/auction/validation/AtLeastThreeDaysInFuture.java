package org.example.auction.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.auction.validator.AtLeastThreeDaysInFutureValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Проверка, что дата находится минимум через 3 дня от текущего момента.
 * Используется для даты начала аукциона.
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = AtLeastThreeDaysInFutureValidator.class)
@Documented
public @interface AtLeastThreeDaysInFuture {
    String message() default "Date must be at least 3 days in the future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}