package org.example.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Категория объявлений с деревом дочерних категорий.
 *
 * <p>Поля: id — уникальный идентификатор, name — название категории,
 * slug — URL-friendly идентификатор, parentId — ID родительской категории (null для корневых),
 * sortOrder — порядок сортировки, children — вложенные дочерние категории,
 * attributes — список атрибутов, принадлежащих категории.</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String slug;
    private Long parentId;
    private Integer sortOrder;
    private List<CategoryDto> children;
    private List<CategoryAttributeDto> attributes;
}
