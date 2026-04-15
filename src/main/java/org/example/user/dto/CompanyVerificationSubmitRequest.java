package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.user.validation.ValidInn;

import java.util.List;

@Schema(description = "Запрос на подтверждение компании")
public record CompanyVerificationSubmitRequest(
        @Schema(example = "Иван Иванов", description = "Имя пользователя")
        @NotBlank(message = "Имя не может быть пустым")
        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        @Pattern(
                regexp = "^[а-яёА-ЯЁa-zA-Z\\s\\-]+$",
                message = "Имя может содержать только буквы, пробелы и дефис"
        )
        String name,

        @Schema(example = "+7 (999) 123-45-67", description = "Номер телефона")
        @JsonProperty("phone_number")
        @NotBlank(message = "Номер телефона обязателен")
        @Pattern(
                regexp = "^(\\+7|8)?\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-]?\\d{2}[-]?\\d{2}$",
                message = "Неверный формат номера телефона"
        )
        String phoneNumber,

        @Schema(example = "7707083893", description = "ИНН компании")
        @NotBlank(message = "ИНН обязателен")
        @ValidInn
        String inn,

        @Schema(example = "ООО Рога и Копыта", description = "Название компании")
        @NotBlank(message = "Название компании обязательно")
        @Size(max = 100, message = "Название компании не более 100 символов")
        @JsonProperty("company_name")
        String companyName,

        @Schema(example = "Петр Петров", description = "Контактное лицо")
        @Size(min = 2, max = 50, message = "Контактное имя должно быть от 2 до 50 символов")
        @JsonProperty("contact_name")
        String contactName,

        @Schema(description = "URL документов для подтверждения")
        @JsonProperty("document_urls")
        List<String> documentUrls
) {
}