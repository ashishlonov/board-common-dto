package org.example.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
///toDo::: подумать потом еще праивльная ли дто
public class CategoryDto {
    private Long id;
    private String name;
    private String slug;
    private Long parentId;
    private Integer sortOrder;
    private List<CategoryDto> children;
    private List<CategoryAttributeDto> attributes;
}
