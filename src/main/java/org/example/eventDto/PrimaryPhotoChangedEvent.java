package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Главное фото владельца изменено.
 *
 * @param ownerId              ID владельца (пользователь или объявление)
 * @param primaryPhotoPublicId новый публичный ID главного фото в Cloudinary
 */
@Builder
public record PrimaryPhotoChangedEvent (
        UUID ownerId,
        String primaryPhotoPublicId
) {
}
