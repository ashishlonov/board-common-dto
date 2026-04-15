package org.example.eventDto;

import java.time.Instant;
import java.util.UUID;

/**
 * Пользователь подписался на аукцион.
 */
public record AuctionSubscribedEvent(
        UUID auctionId,
        String auctionTitle,
        UUID ownerId,
        UUID subscriberId,
        Instant startsAt
) {
}
