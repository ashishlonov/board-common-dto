package org.example.photo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Результат загрузки фото в Cloudinary
 *
 * @param publicId  публичный идентификатор файла в Cloudinary
 * @param secureUrl HTTPS-ссылка на загруженное фото
 * @param width     ширина изображения в пикселях
 * @param height    высота изображения в пикселях
 * @param bytes     размер файла в байтах
 */
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