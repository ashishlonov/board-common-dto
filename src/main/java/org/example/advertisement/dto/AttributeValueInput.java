package org.example.advertisement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.advertisement.validation.ValidAttributeValue;
import tools.jackson.databind.JsonNode;

/**
 * Используется для добавления атрибутов к модели объявления при ее создании
 * @param attributeId
 * @param value
 */
public record AttributeValueInput(
        @NotNull(message = "ID атрибута обязателен")
        @Positive(message = "ID атрибута должен быть положительным")
        Long attributeId,
        @ValidAttributeValue(maxLength = 100)
        JsonNode value
) {}