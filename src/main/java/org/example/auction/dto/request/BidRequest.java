package org.example.auction.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record BidRequest(

        @NotNull
        UUID auctionId,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal amount
) {}