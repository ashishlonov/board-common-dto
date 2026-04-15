package org.example.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CommentCreateRequest (
        @NotBlank(message = "Текст комментария не может быть пустым")
        @Size(min = 1, max = 2000, message = "Текст комментария от 1 до 2000 символов")
        String text,
        UUID parentId
) {
}
