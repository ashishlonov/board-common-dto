package org.example.auction.dto.response;

import lombok.Builder;
import org.example.auction.dto.help.AuctionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
public record AuctionResponse(
        UUID          id,
        UUID advertisementId,
        UUID          ownerId,
        String        title,
        BigDecimal startPrice,
        BigDecimal    currentPrice,
        BigDecimal    minBidStep,
        AuctionStatus status,
        UUID          winnerId,
        Instant startsAt,
        Instant       endsAt,
        int           bidsCount,
        int           maxParticipants,
        int           currentParticipants,
        List<UUID>    participantIds
) {}