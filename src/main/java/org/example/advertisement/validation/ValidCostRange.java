package org.example.advertisement.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.advertisement.validator.CostRangeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CostRangeValidator.class)
public @interface ValidCostRange {
    String message() default "Минимальная цена не может быть больше максимальной";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}