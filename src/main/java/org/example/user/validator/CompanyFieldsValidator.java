package org.example.user.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.user.dto.UserProfileUpdateRequest;
import org.example.user.dto.help.ProfileType;
import org.example.user.validation.ValidCompanyFields;

public class CompanyFieldsValidator
        implements ConstraintValidator<ValidCompanyFields, UserProfileUpdateRequest> {

    @Override
    public boolean isValid(UserProfileUpdateRequest dto,
                           ConstraintValidatorContext ctx) {

        if (dto.profileType() == null) return true;

        if (dto.profileType() == ProfileType.COMPANY) {
            if (dto.companyName() == null || dto.companyName().isBlank()) {
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate(
                                "Для типа COMPANY необходимо указать название компании")
                        .addPropertyNode("companyName")
                        .addConstraintViolation();
                return false;
            }
            if (dto.inn() == null || dto.inn().isBlank()) {
                ctx.buildConstraintViolationWithTemplate("Для типа компания необходимо указать ИНН")
                        .addPropertyNode("inn")
                        .addConstraintViolation();
                return false;
            }
        }

        if (dto.profileType() == ProfileType.PERSONAL
                && dto.companyName() != null
                && !dto.companyName().isBlank()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Для типа PERSONAL поле companyName не нужно")
                    .addPropertyNode("companyName")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}