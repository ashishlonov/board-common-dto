package org.example.user.dto;

import lombok.Builder;

import java.util.UUID;

/**
 * Минимальная информация о пользователе для отображения в чате
 *
 * @param id        уникальный идентификатор
 * @param name      имя пользователя
 * @param avatarUrl URL аватара
 */
@Builder
public record ShortUserChatDto(

        UUID id,

        String name,

        String avatarUrl
) {
}
