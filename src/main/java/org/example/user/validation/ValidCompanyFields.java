package org.example.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.user.validator.CompanyFieldsValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Проверка полей компании на уровне класса.
 * Для профиля типа COMPANY обязательны companyName и inn,
 * для профиля типа PERSONAL companyName не должно быть заполнено.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyFieldsValidator.class)
public @interface ValidCompanyFields {
    String message() default "Для типа COMPANY необходимо указать название компании";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
