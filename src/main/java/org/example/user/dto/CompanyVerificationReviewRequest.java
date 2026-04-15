package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.user.dto.help.VerificationStatus;

import java.util.UUID;

/**
 * Запрос администратора на рассмотрение заявки верификации
 *
 * @param requestId     ID заявки для рассмотрения
 * @param status        решение: APPROVED (одобрить) или REJECTED (отклонить)
 * @param adminComment комментарий администратора (обязателен)
 */
@Schema(description = "Запрос на рассмотрение заявки верификации компании")
public record CompanyVerificationReviewRequest(
        @Schema(description = "ID заявки")
        @NotNull(message = "ID заявки обязателен")
        @JsonProperty("request_id")
        UUID requestId,

        @Schema(description = "Решение: APPROVED или REJECTED")
        @NotNull(message = "Статус обязателен")
        VerificationStatus status,

        @Schema(example = "Документы подтверждены", description = "Комментарий админа")
        @JsonProperty("admin_comment")
        @NotBlank(message = "Комментарий обязателен")
        String adminComment
) {
}