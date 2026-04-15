package org.example.eventDto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Владелец изменил параметры аукциона (шаг, цену).
 */
public record AuctionUpdatedEvent(
        UUID auctionId,
        String auctionTitle,
        BigDecimal newMinBidStep,
        BigDecimal newCurrentPrice
) {
}
