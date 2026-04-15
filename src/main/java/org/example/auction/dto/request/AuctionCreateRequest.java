package org.example.auction.dto.request;

import jakarta.validation.constraints.*;
import org.example.auction.validation.AtLeastThreeDaysInFuture;
import org.example.auction.validation.ValidAuctionDates;
import org.example.auction.validation.ValidMaxParticipants;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Запрос на создание аукциона
 *
 * @param advertisementId  ID объявления, к которому привязан аукцион
 * @param title            название аукциона
 * @param startPrice       стартовая цена
 * @param minBidStep       минимальный шаг ставки
 * @param startsAt         время начала торгов (минимум через 3 дня)
 * @param endsAt           время окончания торгов
 * @param maxParticipants  максимальное число участников (10, 25, 50 или 100)
 */
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