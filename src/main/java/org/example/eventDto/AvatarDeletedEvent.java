package org.example.eventDto;

import java.util.UUID;

public record AvatarDeletedEvent (
        UUID userProfileId
) {
}
