package org.example.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Запрос на изменение роли
 *
 * @param name  новое название роли
 */
public record RoleUpdateRequest(
        @NotBlank(message = "Название роли не может быть пустым")
        @Size(max = 50, message = "Название роли не более 50 символов")
        String name
) {}
