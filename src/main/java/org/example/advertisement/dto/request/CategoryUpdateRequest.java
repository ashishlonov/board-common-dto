package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CategoryUpdateRequest(
        @NotBlank(message = "Название категории не может быть пустым")
        @Size(min = 2, max = 100, message = "Название категории от 2 до 100 символов")
        String name,
        @NotBlank(message = "Slug не может быть пустым")
        @Size(min = 2, max = 100, message = "Slug от 2 до 100 символов")
        @Pattern(regexp = "^[a-z0-9]+(-[a-z0-9]+)*$", message = "Slug может содержать только строчные буквы, цифры и дефис. Пример: real-estate")
        String slug,
        @Positive(message = "ID родительской категории должен быть положительным")
        @JsonProperty("parent_id")
        Long parentId,
        @Min(value = 0, message = "Порядок сортировки не может быть отрицательным")
        @Max(value = 1000, message = "Порядок сортировки не более 1000")
        @JsonProperty("sort_order")
        Integer sortOrder
) {
}
