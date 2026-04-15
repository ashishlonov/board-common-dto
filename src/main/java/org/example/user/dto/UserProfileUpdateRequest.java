package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.user.dto.help.ProfileType;
import org.example.user.validation.ValidCompanyFields;
import org.example.user.validation.ValidInn;

@ValidCompanyFields
public record UserProfileUpdateRequest(
        @Schema(example = "Иван Иванов", description = "Имя пользователя")
        @NotBlank(message = "Имя не может быть пустым")
        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        @Pattern(
                regexp = "^[а-яёА-ЯЁa-zA-Z\\s\\-]+$",
                message = "Имя может содержать только буквы, пробелы и дефис"
        )
        String name,
        @Schema(example = "COMPANY", description = "Тип профиля: PERSONAL или COMPANY")
        @JsonProperty("profile_type")
        ProfileType profileType,
        @Schema(example = "ООО Рога и Копыта", description = "Название компании (обязательно для COMPANY)")
        @Size(max = 100, message = "Название компании не более 100 символов")
        @JsonProperty("company_name")
        String companyName,
        @Schema(example = "7707083893", description = "ИНН компании (10 или 12 цифр)")
        @ValidInn
        @Size(max = 12, message = "ИНН не более 12 символов")
        String inn,
        @Schema(example = "Петр Петров", description = "Контактное лицо")
        @Size(min = 2, max = 50, message = "Контакное имя должно быть от 2 до 50 символов")
        @JsonProperty("contact_name")
        String contactName,
        @Schema(example = "+7 (999) 123-45-67", description = "Номер телефона")
        @JsonProperty("phone_number")
        @NotBlank(message = "Номер телефона обязателен")
        @Pattern(
                regexp = "^(\\+7|8)?\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-]?\\d{2}[-]?\\d{2}$",
                message = "Неверный формат номера телефона. Используйте +7 (XXX) XXX-XX-XX"
        )
        String phoneNumber
) {
}
