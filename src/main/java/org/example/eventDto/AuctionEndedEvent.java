package org.example.eventDto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Аукцион завершился (FINISHED или CANCELLED).
 */
public record AuctionEndedEvent(
        UUID auctionId,
        String title,
        UUID ownerId,
        UUID winnerId,
        BigDecimal finalPrice,
        boolean cancelled
) {
}
