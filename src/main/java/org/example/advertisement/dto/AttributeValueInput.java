package org.example.advertisement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.advertisement.validation.ValidAttributeValue;
import tools.jackson.databind.JsonNode;

/**
 * Ввод значения атрибута при создании объявления
 *
 * @param attributeId  ID атрибута
 * @param value        значение в формате JSON (строка, число, булево и т.д.)
 */
public record AttributeValueInput(
        @NotNull(message = "ID атрибута обязателен")
        @Positive(message = "ID атрибута должен быть положительным")
        Long attributeId,
        @ValidAttributeValue(maxLength = 100)
        Object value
) {}