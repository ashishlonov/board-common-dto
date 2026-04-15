package org.example.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Запрос на редактирование комментария
 *
 * @param text  новый текст комментария (1–2000 символов)
 */
public record CommentUpdateRequest(
        @NotBlank(message = "Текст комментария не может быть пустым")
        @Size(min = 1, max = 2000, message = "Текст комментария от 1 до 2000 символов")
        String text
) {
}
