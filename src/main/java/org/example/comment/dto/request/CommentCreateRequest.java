package org.example.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * Запрос на создание комментария
 *
 * @param text      текст комментария (1–2000 символов)
 * @param parentId  ID родительского комментария (для вложенных ответов, null для корневого)
 */
public record CommentCreateRequest (
        @NotBlank(message = "Текст комментария не может быть пустым")
        @Size(min = 1, max = 2000, message = "Текст комментария от 1 до 2000 символов")
        String text,
        UUID parentId
) {
}
