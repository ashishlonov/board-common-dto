package org.example.auction.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder
public record BidResponse(

        UUID       auctionId,
        UUID       userId,
        BigDecimal amount,
        Instant createdAt
) {}