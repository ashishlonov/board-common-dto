package org.example.auction.dto.request;

import jakarta.validation.constraints.*;
import org.example.auction.validation.AtLeastThreeDaysInFuture;
import org.example.auction.validation.ValidAuctionDates;
import org.example.auction.validation.ValidMaxParticipants;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@ValidAuctionDates
public record AuctionCreateRequest(

        @NotNull
        UUID advertisementId,

        @NotBlank
        @Size(max = 200)
        String title,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal startPrice,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal minBidStep,

        @NotNull
        @AtLeastThreeDaysInFuture
        Instant startsAt,

        @NotNull
        @Future
        Instant endsAt,

        @NotNull
        @ValidMaxParticipants
        Integer maxParticipants
) {}