package org.example.auction.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.auction.validator.AuctionDateValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuctionDateValidator.class)
@Documented
public @interface ValidAuctionDates {
    String message() default "Invalid auction dates";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}