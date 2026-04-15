package org.example.auction.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AuctionUpdateRequest(

        @JsonProperty("min_bid_step")
        BigDecimal minBidStep,

        @JsonProperty("current_price")
        BigDecimal currentPrice

) {
}
