package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;

/**
 * Запрос на создание категории
 *
 * @param name       название категории (2–100 символов)
 * @param slug       URL-friendly идентификатор (опционально, генерируется автоматически)
 * @param parentId   ID родительской категории (для вложенности)
 * @param sortOrder  порядок сортировки (0–1000)
 */
@Builder
public record CategoryCreateRequest (
        @NotBlank(message = "Название категории не может быть пустым")
        @Size(min = 2, max = 100, message = "Название категории от 2 до 100 символов")
        String name,
        @Size(min = 2, max = 100, message = "Slug до 100 символов (опционально — будет сгенерирован автоматически)")
        @Pattern(
                regexp = "^[a-z0-9]+(-[a-z0-9]+)*$",
                message = "Slug: только строчные буквы, цифры и дефис. Пример: real-estate"
        )
        String slug,
        @JsonProperty("parent_id")
        @Positive(message = "ID родительской категории должен быть положительным")
        Long parentId,
        @JsonProperty("sort_order")
        @Min(value = 0, message = "Порядок сортировки не может быть отрицательным")
        @Max(value = 1000, message = "Порядок сортировки не более 1000")
        Integer sortOrder
) {
}
