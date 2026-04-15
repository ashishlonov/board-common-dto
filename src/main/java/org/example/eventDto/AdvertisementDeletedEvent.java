package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AdvertisementDeletedEvent (
        UUID advertisementId
) {
}
