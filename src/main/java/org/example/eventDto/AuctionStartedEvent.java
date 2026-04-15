package org.example.eventDto;

import java.time.Instant;
import java.util.UUID;

/**
 * Аукцион начался (перешёл в статус ACTIVE).
 */
public record AuctionStartedEvent(
        UUID auctionId,
        String title,
        UUID ownerId,
        Instant endsAt
) {
}
