package org.example.advertisement.dto;

import lombok.Builder;
import org.example.advertisement.dto.help.AttributeType;

/**
 * Атрибут категории — характеристика, которую можно задать объявлениям этой категории
 *
 * @param id            уникальный идентификатор
 * @param name          название (например, "Цвет", "Размер")
 * @param code          уникальный код (например, "color", "size")
 * @param attributeType тип: строка, число, дата, булево, выбор, мультивыбор
 * @param unit          единица измерения (например, "кг", "см")
 * @param optionsJson   JSON-список вариантов для SELECT/MULTISELECT
 * @param isRequired    обязателен ли атрибут при создании объявления
 * @param sortOrder     порядок отображения
 */
@Builder
public record CategoryAttributeDto (
        Long id,
        String name,
        String code,
        AttributeType attributeType,
        String unit,
        String optionsJson,
        Boolean isRequired,
        Integer sortOrder
){
}
