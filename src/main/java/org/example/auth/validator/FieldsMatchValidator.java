package org.example.auth.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.auth.validation.FieldsMatch;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String field;
    private String fieldMatch;
    private boolean shouldMatch;
    private String message;

    @Override
    public void initialize(FieldsMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
        this.shouldMatch = constraintAnnotation.shouldMatch();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(o);

        Object fieldValue = beanWrapper.getPropertyValue(field);
        Object fieldMatchValue = beanWrapper.getPropertyValue(fieldMatch);

        boolean isValid;

        if (shouldMatch) {
            isValid = fieldValue != null && fieldValue.equals(fieldMatchValue);
        } else {
            isValid = fieldValue == null || !fieldValue.equals(fieldMatchValue);
        }

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();

            String errorMessage = message != null && !message.isEmpty() ? message :
                    (shouldMatch ? "Поля должны совпадать" : "Поля не должны совпадать");

            constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage)
                    .addPropertyNode(fieldMatch)
                    .addConstraintViolation();
        }

        return isValid;
    }
}
