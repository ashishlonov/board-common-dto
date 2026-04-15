package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.example.advertisement.dto.AttributeValueInput;
import org.example.advertisement.dto.help.Location;

import java.math.BigDecimal;
import java.util.List;

/**
 * Используется для изменения модели объявления
 * @param name
 * @param description
 * @param cost
 * @param location
 * @param isActive
 * @param attributes
 */
public record AdvertisementUpdateRequest(
        @NotBlank(message = "Название не может быть пустым")
        @Size(min = 3, max = 100, message = "Название от 3 до 100 символов")
        String name,
        @Size(max = 5000, message = "Описание не более 5000 символов")
        String description,
        @NotNull(message = "Цена обязательна")
        @DecimalMin(value = "0.0", inclusive = false,
                message = "Цена должна быть больше 0")
        @DecimalMax(value = "999999999.99",
                message = "Цена слишком большая")
        @Digits(integer = 10, fraction = 2,
                message = "Цена: максимум 10 цифр до запятой и 2 после")
        BigDecimal cost,
        @Valid
        Location location,
        @JsonProperty("is_active")
        Boolean isActive,
        @Valid
        List<AttributeValueInput> attributes
) {
}
