package org.example.advertisement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.advertisement.dto.AdvertisementAttributeValueDto;
import org.example.advertisement.dto.help.Location;
import org.example.photo.dto.PhotoToAdvertDto;
import org.example.user.dto.ShortUserDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 *   Используется при отдаче модели объявления при:
 *    - создании
 *    - получения конкретного объявления по id
 *    - обновлении модели
 * @param id
 * @param name
 * @param description
 * @param cost
 * @param location
 * @param categoryId
 * @param categoryName
 * @param owner
 * @param attributes
 * @param photos
 * @param isActive
 * @param createdAt
 */
@Builder
public record AdvertisementResponseDto(
        UUID id,
        String name,
        String description,
        BigDecimal cost,
        Location location,
        @JsonProperty("category_id")
        Long categoryId,
        @JsonProperty("view_count")
        Integer viewCount,
        @JsonProperty("category_name")
        String categoryName,
        @JsonProperty("primary_photo_url")
        String primaryPhotoUrl,
        ShortUserDto owner,
        List<AdvertisementAttributeValueDto> attributes,
        List<PhotoToAdvertDto> photos,
        ///toDO::: возможно стоит переделать чтобы статусы разные бюыли а не просто активен или нет
        @JsonProperty("is_active")
        Boolean isActive,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("updated_at")
        Instant updatedAt,
        @JsonProperty("deleted_at")
        Instant deletedAt
) {

}
