package org.example.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.user.validator.InnValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка формата российского ИНН.
 * Допустимы 10 цифр (юридическое лицо) или 12 цифр (ИП) с проверкой контрольной суммы.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InnValidator.class)
public @interface ValidInn {
    String message() default "Некорректный ИНН";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
