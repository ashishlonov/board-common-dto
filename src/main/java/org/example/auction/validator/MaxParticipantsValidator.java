package org.example.auction.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.auction.validation.ValidMaxParticipants;
import org.example.auction.dto.help.AuctionConfigConstants;

public class MaxParticipantsValidator implements ConstraintValidator<ValidMaxParticipants, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (!AuctionConfigConstants.isValidMaxParticipants(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            "maxParticipants must be one of: 10, 25, 50, 100")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
