package org.example.advertisement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Помогает в поиске по фильтрам
 * @param code
 * @param valueString
 * @param valueFrom
 * @param valueTo
 */
@Builder
public record AttributeFilterDto(
        @NotBlank(message = "Код атрибута обязателен")
        @Size(max = 100, message = "Код атрибута не более 100 символов")
        @Pattern(
                regexp = "^[a-z0-9_]+$",
                message = "Код атрибута: только строчные буквы, цифры и подчёркивание"
        )
        String code,
        @Size(max = 1000, message = "Значение не более 1000 символов")
        @JsonProperty("value_string")
        String valueString,
        @DecimalMin(value = "0.0", inclusive = true,
                message = "Минимальное значение не может быть отрицательным")
        @Digits(integer = 10, fraction = 2,
                message = "Некорректный формат минимального значения")
        @JsonProperty("value_from")
        BigDecimal valueFrom,
        @DecimalMin(value = "0.0", inclusive = true,
                message = "Максимальное значение не может быть отрицательным")
        @Digits(integer = 10, fraction = 2,
                message = "Некорректный формат максимального значения")
        @JsonProperty("value_to")
        BigDecimal valueTo
) {
}
