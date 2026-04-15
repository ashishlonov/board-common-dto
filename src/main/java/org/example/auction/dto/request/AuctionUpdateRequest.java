package org.example.auction.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Запрос на обновление аукциона (все поля опциональны)
 *
 * @param minBidStep   новый минимальный шаг ставки
 * @param currentPrice новая текущая цена
 */
@Builder
public record AuctionUpdateRequest(

        @JsonProperty("min_bid_step")
        BigDecimal minBidStep,

        @JsonProperty("current_price")
        BigDecimal currentPrice

) {
}
