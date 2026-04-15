package org.example.advertisement.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.example.advertisement.dto.AttributeValueInput;
import org.example.advertisement.dto.help.Location;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Запрос на создание объявления
 *
 * @param name         название объявления (3–100 символов)
 * @param description  описание (до 5000 символов)
 * @param cost         цена
 * @param location     адрес (страна, город, улица, дом)
 * @param categoryId   ID категории, к которой относится объявление
 * @param attributes   список значений атрибутов категории
 * @param tempPhotoIds ID временных фото, загруженных до создания объявления (макс. 10)
 */
@Builder
public record AdvertisementCreateRequestDto(
        @NotBlank(message = "Название не может быть пустым")
        @Size(min = 3, max = 100, message = "Название от 3 до 100 символов")
        String name,
        @Size(max = 5000, message = "Описание не более 5000 символов")
        String description,
        @NotNull(message = "Цена обязательна")
        @DecimalMin(value = "0.0", message = "Цена должна быть больше 0")
        @DecimalMax(value = "999999999.99", message = "Цена слишком большая")
        @Digits(integer = 10, fraction = 2, message = "Цена: максимум 10 цифр до запятой и 2 после")
        BigDecimal cost,
        @NotNull(message = "Локация обязательна")
        @Valid
        Location location,
        @NotNull(message = "Категория обязательна")
        Long categoryId,
        @Valid
        List<AttributeValueInput> attributes,
        @Size(max = 10, message = "Максимум 10 фото")
        List<UUID> tempPhotoIds
) {
}

