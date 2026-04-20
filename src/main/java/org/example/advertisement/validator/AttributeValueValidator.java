package org.example.advertisement.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.advertisement.validation.ValidAttributeValue;

public class AttributeValueValidator implements ConstraintValidator<ValidAttributeValue, Object> {

    private int maxLength;

    @Override
    public void initialize(ValidAttributeValue annotation) {
        this.maxLength = annotation.maxLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext ctx) {
        if (value == null) return true;

        if (value instanceof java.util.Map) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("Значение атрибута не может быть объектом")
                    .addConstraintViolation();
            return false;
        }

        if (value instanceof java.util.Collection) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("Значение атрибута не может быть массивом")
                    .addConstraintViolation();
            return false;
        }

        if (value instanceof Number num) {
            if (num.doubleValue() < 0) {
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate("Числовое значение атрибута не может быть отрицательным")
                        .addConstraintViolation();
                return false;
            }
            return true;
        }

        String stringValue = value.toString();
        if (stringValue.length() > maxLength) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Значение атрибута не более %d символов".formatted(maxLength))
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}