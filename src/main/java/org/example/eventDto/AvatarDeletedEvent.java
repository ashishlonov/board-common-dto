package org.example.eventDto;

import java.util.UUID;

/**
 * Аватар пользователя удалён.
 *
 * @param userProfileId  ID пользователя, чей аватар удалён
 */
public record AvatarDeletedEvent (
        UUID userProfileId
) {
}
