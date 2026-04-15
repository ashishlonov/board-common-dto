package org.example.eventDto;

import java.util.UUID;

/**
 * Пользователь отписался от аукциона.
 */
public record AuctionUnsubscribedEvent(
        UUID auctionId,
        String auctionTitle,
        UUID ownerId,
        UUID unsubscribedId
) {
}
