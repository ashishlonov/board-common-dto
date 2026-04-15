package org.example.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record LoginUserRequest (
        @NotBlank(message = "Email не может быть пустым")
        @Email(message = "Некорректный формат email")
        String email,
        @NotBlank(message = "Пароль не может быть пустым")
        String password
){
}
