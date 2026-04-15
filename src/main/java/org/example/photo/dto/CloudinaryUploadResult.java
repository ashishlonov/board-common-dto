package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CloudinaryUploadResult(
        @JsonProperty("public_id")
        String publicId,
        @JsonProperty("secure_url")
        String secureUrl,
        Integer width,
        Integer height,
        Long bytes
) {}