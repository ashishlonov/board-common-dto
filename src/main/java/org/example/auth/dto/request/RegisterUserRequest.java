package org.example.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.example.auth.validation.FieldsMatch;

@Builder
@FieldsMatch(field = "password", fieldMatch = "confirmPassword")
public record RegisterUserRequest(
        @NotBlank(message = "Email не может быть пустым")
        @Email(message = "Некорректный формат email")
        String email,
        @NotBlank(message = "Пароль не может быть пустым")
        @Size(min = 8, max = 64, message = "Пароль должен быть от 8 до 64 символов")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
                message = "Пароль должен содержать цифру, строчную, заглавную букву и спецсимвол"
        )
        String password,
        @JsonProperty("confirm_password")
        @NotBlank(message = "Подтверждение пароля обязательно")
        String confirmPassword,
        @NotBlank(message = "Имя не может быть пустым")
        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        @Pattern(
                regexp = "^[а-яёА-ЯЁa-zA-Z\\s\\-]+$",
                message = "Имя может содержать только буквы, пробелы и дефис"
        )
        String name,
        @JsonProperty("phone_number")
        @NotBlank(message = "Номер телефона обязателен")
        @Pattern(
                regexp = "^(\\+7|8)?\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-]?\\d{2}[-]?\\d{2}$",
                message = "Неверный формат номера телефона. Используйте +7 (XXX) XXX-XX-XX"
        )
        String phoneNumber,
        @NotBlank(message = "Введите текст с картинки")
        @Size(min = 4, max = 8, message = "Некорректный текст с картинки")
        @JsonProperty("captcha_text")
        String captchaText,
        @NotBlank(message = "Токен отсутствует")
        @JsonProperty("captcha_token")
        String captchaToken
) {
}
