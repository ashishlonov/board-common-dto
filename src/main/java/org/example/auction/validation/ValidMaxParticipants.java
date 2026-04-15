package org.example.auction.validation;

import jakarta.validation.Constraint;
import org.example.auction.validator.MaxParticipantsValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxParticipantsValidator.class)
@Documented
public @interface ValidMaxParticipants {
    String message() default "maxParticipants must be one of the allowed values: 10, 25, 50, 100";
    Class<?>[] groups() default {};
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
