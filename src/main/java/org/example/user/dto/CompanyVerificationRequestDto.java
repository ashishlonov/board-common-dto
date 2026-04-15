package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.user.dto.help.VerificationStatus;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Schema(description = "Заявка на верификацию компании")
public record CompanyVerificationRequestDto(
        @Schema(description = "ID заявки")
        UUID id,

        @Schema(description = "ID пользователя")
        @JsonProperty("user_id")
        UUID userId,

        @Schema(description = "Имя пользователя")
        @JsonProperty("user_name")
        String userName,

        @Schema(description = "ИНН")
        String inn,

        @Schema(description = "Название компании")
        @JsonProperty("company_name")
        String companyName,

        @Schema(description = "Контактное лицо")
        @JsonProperty("contact_name")
        String contactName,

        @Schema(description = "URL документов")
        @JsonProperty("document_urls")
        List<String> documentUrls,

        @Schema(description = "Статус")
        VerificationStatus status,

        @Schema(description = "Комментарий админа")
        @JsonProperty("admin_comment")
        String adminComment,

        @Schema(description = "Дата создания")
        @JsonProperty("created_at")
        Instant createdAt,

        @Schema(description = "Дата рассмотрения")
        @JsonProperty("reviewed_at")
        Instant reviewedAt
) {
}