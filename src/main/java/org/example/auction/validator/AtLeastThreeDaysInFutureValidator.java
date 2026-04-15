package org.example.auction.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.auction.validation.AtLeastThreeDaysInFuture;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class AtLeastThreeDaysInFutureValidator
        implements ConstraintValidator<AtLeastThreeDaysInFuture, Instant> {

    @Override
    public boolean isValid(Instant value, ConstraintValidatorContext context) {
        if (value == null) return true;
        Instant threeDaysFromNow = Instant.now().plus(3, ChronoUnit.DAYS);
        return value.isAfter(threeDaysFromNow);
    }
}