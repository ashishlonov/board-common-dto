package org.example.eventDto;

import java.util.UUID;

/**
 * Владелец удалил аукцион.
 */
public record AuctionDeletedEvent(
        UUID auctionId,
        String auctionTitle,
        UUID ownerId
) {
}
