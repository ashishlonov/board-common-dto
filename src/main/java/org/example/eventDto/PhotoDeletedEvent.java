package org.example.eventDto;

import org.example.photo.dto.help.OwnerType;

import java.util.UUID;

/**
 * Фото удалено.
 *
 * @param ownerId    ID владельца фото
 * @param ownerType  тип владельца (пользователь, объявление, документ)
 */
public record PhotoDeletedEvent (
        UUID ownerId,
        OwnerType ownerType
) {
}
