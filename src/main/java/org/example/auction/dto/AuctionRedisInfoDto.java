package org.example.auction.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record AuctionRedisInfoDto(
        UUID auctionId,
        UUID ownerId,
        BigDecimal currentPrice,
        BigDecimal minBidStep,
        Instant endsAt
) {}