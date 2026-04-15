package org.example.advertisement.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.advertisement.dto.request.AdvertisementSearchRequest;
import org.example.advertisement.validation.ValidCostRange;

public class CostRangeValidator implements ConstraintValidator<ValidCostRange, AdvertisementSearchRequest> {

    @Override
    public boolean isValid(AdvertisementSearchRequest dto, ConstraintValidatorContext ctx) {
        if (dto.getCostFrom() == null || dto.getCostTo() == null) {
            return true;
        }
        return dto.getCostFrom().compareTo(dto.getCostTo()) <= 0;
    }
}