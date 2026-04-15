package org.example.advertisement.dto;

import lombok.Builder;

import java.util.UUID;

/**
 * Минимальная информация об объявлении для отображения в чате
 *
 * @param id               уникальный идентификатор объявления
 * @param name             название объявления
 * @param primaryPhotoUrl  URL главного фото
 * @param ownerId          ID владельца объявления
 */
@Builder
public record AdvertisementInfoForChatDto(
        UUID id,

        String name,

        String primaryPhotoUrl,

        UUID ownerId
) {
}
