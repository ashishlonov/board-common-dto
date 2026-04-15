package org.example.advertisement.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.advertisement.validation.ValidAttributeValue;
import tools.jackson.databind.JsonNode;

public class AttributeValueValidator
        implements ConstraintValidator<ValidAttributeValue, JsonNode> {

    private int maxLength;

    @Override
    public void initialize(ValidAttributeValue annotation) {
        this.maxLength = annotation.maxLength();
    }

    @Override
    public boolean isValid(JsonNode value, ConstraintValidatorContext ctx) {

        if (value == null || value.isNull()) return true;

        if (value.isObject()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Значение атрибута не может быть объектом")
                    .addConstraintViolation();
            return false;
        }

        if (value.isArray()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Значение атрибута не может быть массивом")
                    .addConstraintViolation();
            return false;
        }

        String stringValue = value.isTextual()
                ? value.asText()
                : value.toString();

        if (stringValue.length() > maxLength) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Значение атрибута не более %d символов"
                                    .formatted(maxLength))
                    .addConstraintViolation();
            return false;
        }

        if (value.isNumber() && value.asDouble() < 0) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Числовое значение атрибута не может быть отрицательным")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}