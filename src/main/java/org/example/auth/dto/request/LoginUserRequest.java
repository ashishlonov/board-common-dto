package org.example.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


/**
 * Запрос на вход (авторизация)
 *
 * @param email     email пользователя
 * @param password  пароль
 */
@Builder
public record LoginUserRequest (
        @NotBlank(message = "Email не может быть пустым")
        @Email(message = "Некорректный формат email")
        String email,
        @NotBlank(message = "Пароль не может быть пустым")
        String password
){
}
