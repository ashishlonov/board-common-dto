package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

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