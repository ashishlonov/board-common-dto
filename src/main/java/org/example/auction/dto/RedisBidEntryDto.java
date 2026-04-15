package org.example.auction.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record RedisBidEntryDto(
        UUID userId,
        BigDecimal amount,
        Instant createdAt
) {}