package org.example.advertisement.dto;

import lombok.Builder;
import org.example.advertisement.dto.help.AttributeType;

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
