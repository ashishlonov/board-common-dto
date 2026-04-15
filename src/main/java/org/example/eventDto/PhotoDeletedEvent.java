package org.example.eventDto;

import org.example.photo.dto.help.OwnerType;

import java.util.UUID;

public record PhotoDeletedEvent (
        UUID ownerId,
        OwnerType ownerType
) {
}
