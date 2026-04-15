package org.example.advertisement.dto;

import lombok.Builder;
import org.example.advertisement.dto.help.AttributeType;

/**
 * Используется для полноценной отдачи характеристик атрибутов модели
 * @param attributeId
 * @param name
 * @param code
 * @param type
 * @param unit
 * @param isRequired
 * @param value
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
