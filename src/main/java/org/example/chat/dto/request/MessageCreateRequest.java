package org.example.chat.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Запрос на отправку сообщения в чат
 *
 * @param text  текст сообщения (до 5000 символов)
 */
public record MessageCreateRequest(
        @NotBlank(message = "Сообщение не может быть пустым")
        @Size(max = 5000, message = "Сообщение не более 5000 символов")
        String text
) {
}
