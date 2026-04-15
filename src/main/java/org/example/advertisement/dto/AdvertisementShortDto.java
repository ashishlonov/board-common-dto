package org.example.advertisement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.advertisement.dto.help.Location;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record AdvertisementShortDto(
        UUID id,
        String name,
        BigDecimal cost,
        Location location,
        @JsonProperty("primary_photo_url")
        String primaryPhotoUrl,
        @JsonProperty("is_active")
        Boolean isActive,
        @JsonProperty("deleted_at")
        java.time.Instant deletedAt
) {
    public boolean isPrimary() { return false; }
}
