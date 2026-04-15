package org.example.auth.dto.response;

import java.util.UUID;

/**
 * Представление роли пользователя
 *
 * @param id    уникальный идентификатор роли
 * @param name  название роли
 */
public record RoleDto(
        UUID id,
        String name
) {}
