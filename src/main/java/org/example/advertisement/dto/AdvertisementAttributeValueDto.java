package org.example.advertisement.dto;

import lombok.Builder;
import org.example.advertisement.dto.help.AttributeType;

/**
 * Значение атрибута объявления с полной информацией
 *
 * @param attributeId  ID атрибута
 * @param name         название атрибута
 * @param code         уникальный код атрибута
 * @param type         тип значения (строка, число, дата и т.д.)
 * @param unit         единица измерения
 * @param isRequired   обязателен ли атрибут
 * @param value        само значение (может быть любого типа)
 */
@Builder
public record AdvertisementAttributeValueDto(
        Long attributeId,
        String name,
        String code,
        AttributeType type,
        String unit,
        Boolean isRequired,
        Object value
) {
}
