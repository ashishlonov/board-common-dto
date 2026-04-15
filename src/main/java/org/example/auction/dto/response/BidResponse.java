package org.example.auction.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Ответ с информацией о ставке
 *
 * @param auctionId ID аукциона
 * @param userId    ID пользователя, сделавшего ставку
 * @param amount    сумма ставки
 * @param createdAt время ставки
 */
@Builder
public record BidResponse(

        UUID       auctionId,
        UUID       userId,
        BigDecimal amount,
        Instant createdAt
) {}