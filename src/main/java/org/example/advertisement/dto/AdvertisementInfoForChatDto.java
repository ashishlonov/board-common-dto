package org.example.advertisement.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AdvertisementInfoForChatDto(
        UUID id,

        String name,

        String primaryPhotoUrl,

        UUID ownerId
) {
}
