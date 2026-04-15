package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Объявление удалено.
 *
 * @param advertisementId  ID удалённого объявления
 */
@Builder
public record AdvertisementDeletedEvent (
        UUID advertisementId
) {
}
