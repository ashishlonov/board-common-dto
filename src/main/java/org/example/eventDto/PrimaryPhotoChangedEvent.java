package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PrimaryPhotoChangedEvent (
        UUID ownerId,
        String primaryPhotoPublicId
) {
}
