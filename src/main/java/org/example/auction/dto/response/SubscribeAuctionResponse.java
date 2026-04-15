package org.example.auction.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/**
 * Подтверждение подписки на аукцион
 *
 * @param auctionId ID аукциона
 * @param title     название аукциона
 * @param startsAt  время начала торгов
 */
@Builder
public record SubscribeAuctionResponse(

        @JsonProperty("auction_id")
        UUID auctionId,

        String title,

        @JsonProperty("starts_at")
        Instant startsAt
) {
}
