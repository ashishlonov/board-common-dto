package org.example.auction.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Запрос на размещение ставки
 *
 * @param auctionId ID аукциона
 * @param amount    сумма ставки
 */
public record BidRequest(

        @NotNull
        UUID auctionId,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal amount
) {}