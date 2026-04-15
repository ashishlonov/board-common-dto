package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.advertisement.dto.help.AttributeType;

public record CategoryAttributeCreateRequest(
        @NotBlank(message = "Название атрибута не может быть пустым")
        @Size(min = 2, max = 100,
                message = "Название атрибута от 2 до 100 символов")
        String name,
        @NotBlank(message = "Код атрибута не может быть пустым")
        @Size(min = 2, max = 100,
                message = "Код атрибута от 2 до 100 символов")
        @Pattern(
                regexp = "^[a-z0-9_]+$",
                message = "Код атрибута: только строчные буквы, цифры и подчёркивание"
        )
        String code,
        @NotNull(message = "Тип атрибута обязателен")
        @JsonProperty("attribute_type")
        AttributeType attributeType,
        @Size(max = 10, message = "Единица измерения не более 10 символов")
        String unit,
        @Size(max = 500, message = "Список опций не более 500 символов")
        @JsonProperty("options_json")
        String optionsJson,
        @JsonProperty("is_required")
        Boolean isRequired
) {}