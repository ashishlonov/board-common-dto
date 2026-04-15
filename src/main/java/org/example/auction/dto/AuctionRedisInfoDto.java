package org.example.auction.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Лёгкая информация об аукционе для хранения в Redis
 *
 * @param auctionId    ID аукциона
 * @param ownerId      ID владельца
 * @param currentPrice текущая цена (последняя ставка)
 * @param minBidStep   минимальный шаг ставки
 * @param endsAt       время окончания аукциона
 */
public record AuctionRedisInfoDto(
        UUID auctionId,
        UUID ownerId,
        BigDecimal currentPrice,
        BigDecimal minBidStep,
        Instant endsAt
) {}