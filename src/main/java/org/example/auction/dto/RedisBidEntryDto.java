package org.example.auction.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Запись ставки, хранящаяся в Redis
 *
 * @param userId    ID пользователя, сделавшего ставку
 * @param amount    сумма ставки
 * @param createdAt время ставки
 */
public record RedisBidEntryDto(
        UUID userId,
        BigDecimal amount,
        Instant createdAt
) {}