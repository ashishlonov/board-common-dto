package org.example.advertisement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.advertisement.dto.help.Location;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Краткая карточка объявления для списков и превью
 */
/**
 * Краткая карточка объявления для списков и превью
 *
 * @param id               уникальный идентификатор объявления
 * @param name             название объявления
 * @param cost             цена
 * @param location         адрес (страна, город, улица, дом, форматированный адрес)
 * @param primaryPhotoUrl  URL главного фото
 * @param isActive         активно ли объявление
 * @param deletedAt        дата удаления (если удалено)
 */
@Builder
public record AdvertisementShortDto(
        UUID id,
        String name,
        Integer cost,
        Location location,
        @JsonProperty("primary_photo_url")
        String primaryPhotoUrl,
        @JsonProperty("is_active")
        Boolean isActive,
        @JsonProperty("deleted_at")
        java.time.Instant deletedAt
) {
}
