package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

public record TempPhotoDto(
        UUID id,
        @JsonProperty("thumbnail_url")
        String thumbnailUrl,
        @JsonProperty("medium_url")
        String mediumUrl,
        @JsonProperty("expires_at")
        Instant expiresAt
) {}