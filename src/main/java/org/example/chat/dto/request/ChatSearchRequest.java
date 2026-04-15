package org.example.chat.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Поиск чатов с пагинацией.
 *
 * <p>Поля: page — номер страницы (начиная с 0), size — размер страницы (1–100),
 * name — фильтр по названию чата.</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatSearchRequest {
    @Min(value = 0, message = "Номер страницы не может быть отрицательным")
    private int page = 0;
    @Min(value = 1, message = "Размер страницы минимум 1")
    @Max(value = 100, message = "Размер страницы максимум 100")
    private int size = 20;
    @Size(max = 100, message = "Название не более 100 символов")
    private String name;
}
