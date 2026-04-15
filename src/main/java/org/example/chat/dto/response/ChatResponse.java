package org.example.chat.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/**
 * Карточка чата в списке диалогов
 *
 * @param id                уникальный идентификатор чата
 * @param opponent          имя собеседника
 * @param avatarOfOpponent  аватар собеседника
 * @param title             заголовок чата
 * @param photoUrl          фото объявления
 * @param lastMessage       текст последнего сообщения
 * @param lastMessageAt     время последнего сообщения
 * @param createdAt         время создания чата
 */
@Builder
public record ChatResponse (
        UUID id,

        String opponent,

        @JsonProperty("avatar_of_opponent")
        String avatarOfOpponent,

        String title,

        @JsonProperty("photo_url")
        String photoUrl,

        @JsonProperty("last_message")
        String lastMessage,

        @JsonProperty("last_message_at")
        Instant lastMessageAt,

        @JsonProperty("created_at")
        Instant createdAt
) {
}
