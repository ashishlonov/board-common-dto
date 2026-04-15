package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

/**
 * Фотография, привязанная к объявлению
 *
 * @param id           уникальный идентификатор
 * @param thumbnailUrl URL миниатюры
 * @param mediumUrl    URL среднего размера
 * @param isPrimary    является ли главным фото объявления
 */
@Builder
public record PhotoToAdvertDto(
        UUID id,
        @JsonProperty("thumbnail_url")
        String thumbnailUrl,
        @JsonProperty("medium_url")
        String mediumUrl,
        @JsonProperty("is_primary")
        Boolean isPrimary
) {
}
