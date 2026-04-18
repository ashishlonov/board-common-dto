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
 * Полный ответ с информацией об объявлении
 *
 * @param id               уникальный идентификатор
 * @param name             название
 * @param description      описание
 * @param cost             цена
 * @param location         адрес
 * @param categoryId       ID категории
 * @param viewCount        количество просмотров
 * @param categoryName     название категории
 * @param primaryPhotoUrl  URL главного фото
 * @param owner            данные владельца
 * @param attributes       значения атрибутов
 * @param photos           список фото
 * @param isActive         активно ли объявление
 * @param createdAt        дата создания
 * @param updatedAt        дата последнего обновления
 * @param deletedAt        дата удаления (если удалено)
 */
@Builder
public record AdvertisementResponseDto(
        UUID id,
        String name,
        String description,
        Integer cost,
        Location location,
        @JsonProperty("category_id")
        Integer categoryId,
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
