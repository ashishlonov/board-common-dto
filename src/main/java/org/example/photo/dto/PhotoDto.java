package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/**
 * Полные данные фотографии
 *
 * @param id             уникальный идентификатор
 * @param photoType      тип (аватар, главное, галерея)
 * @param sortOrder      порядок сортировки в галерее
 * @param isPrimary      является ли главным фото
 * @param thumbnailUrl   URL миниатюры
 * @param mediumUrl      URL среднего размера
 * @param originalUrl    URL оригинала
 * @param fileSizeBytes  размер файла в байтах
 * @param createdAt      время загрузки
 * @param deletedAt      время удаления (если удалено)
 */
@Builder
public record PhotoDto(
        UUID id,
        @JsonProperty("photo_type")
        String photoType,
        @JsonProperty("sort_order")
        Integer sortOrder,
        @JsonProperty("is_primary")
        Boolean isPrimary,
        @JsonProperty("thumbnail_url")
        String thumbnailUrl,
        @JsonProperty("medium_url")
        String mediumUrl,
        @JsonProperty("original_url")
        String originalUrl,
        @JsonProperty("file_size_bytes")
        Long fileSizeBytes,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("deleted_at")
        Instant deletedAt
) {}