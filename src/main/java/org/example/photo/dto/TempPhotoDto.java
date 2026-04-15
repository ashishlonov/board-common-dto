package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

/**
 * Временная фотография, загруженная до создания объявления
 *
 * @param id           уникальный идентификатор
 * @param thumbnailUrl URL миниатюры
 * @param mediumUrl    URL среднего размера
 * @param expiresAt    время истечения (фото удаляется, если не привязано к объявлению)
 */
public record TempPhotoDto(
        UUID id,
        @JsonProperty("thumbnail_url")
        String thumbnailUrl,
        @JsonProperty("medium_url")
        String mediumUrl,
        @JsonProperty("expires_at")
        Instant expiresAt
) {}