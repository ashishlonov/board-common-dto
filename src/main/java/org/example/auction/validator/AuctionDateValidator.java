package org.example.auction.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.auction.dto.request.AuctionCreateRequest;
import org.example.auction.validation.ValidAuctionDates;

import java.time.Duration;
import java.time.Instant;

public class AuctionDateValidator implements ConstraintValidator<ValidAuctionDates, AuctionCreateRequest> {

    private static final long MIN_DURATION_MINUTES = 10;
    private static final long MAX_DURATION_HOURS = 24;

    @Override
    public boolean isValid(AuctionCreateRequest request, ConstraintValidatorContext context) {
        if (request == null || request.startsAt() == null || request.endsAt() == null) {
            return true;
        }

        Instant startsAt = request.startsAt();
        Instant endsAt = request.endsAt();

        if (!endsAt.isAfter(startsAt)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("endsAt must be after startsAt")
                    .addPropertyNode("endsAt")
                    .addConstraintViolation();
            return false;
        }

        Duration duration = Duration.between(startsAt, endsAt);
        if (duration.toHours() > MAX_DURATION_HOURS) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            String.format("Auction duration must not exceed %d hour(s)", MAX_DURATION_HOURS))
                    .addPropertyNode("endsAt")
                    .addConstraintViolation();
            return false;
        }


        if (duration.toMinutes() < MIN_DURATION_MINUTES) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            String.format("Auction duration must be at least %d minute(s)", MIN_DURATION_MINUTES))
                    .addPropertyNode("endsAt")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}