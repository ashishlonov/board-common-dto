package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.advertisement.dto.help.AttributeType;

/**
 * Запрос на редактирование атрибута категории (все поля опциональны)
 *
 * @param name          новое название
 * @param code          новый код
 * @param attributeType новый тип
 * @param unit          новая единица измерения
 * @param optionsJson   новый JSON вариантов
 * @param isRequired    новый флаг обязательности
 */
public record CategoryAttributeUpdateRequest(
        @Size(min = 2, max = 100, message = "Название атрибута от 2 до 100 символов")
        String name,
        @Size(min = 2, max = 100,
                message = "Код атрибута от 2 до 100 символов")
        @Pattern(
                regexp = "^$|^[a-z0-9_]+$",
                message = "Код атрибута: только строчные буквы, цифры и подчёркивание"
        )
        String code,
        @JsonProperty("attribute_type")
        AttributeType attributeType,
        @Size(max = 20, message = "Единица измерения не более 20 символов")
        String unit,
        @JsonProperty("options_json")
        @Size(max = 5000, message = "Список опций не более 5000 символов")
        String optionsJson,
        @JsonProperty("is_required")
        Boolean isRequired
) {
}
