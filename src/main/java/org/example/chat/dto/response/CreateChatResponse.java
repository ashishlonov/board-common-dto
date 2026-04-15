package org.example.chat.dto.response;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

/**
 * Результат создания чата
 *
 * @param id              уникальный идентификатор чата
 * @param title           заголовок чата
 * @param advertisementId ID объявления, к которому привязан чат
 * @param sellerId        ID продавца
 * @param buyerId         ID покупателя
 * @param createdAt       время создания
 */
@Builder
public record CreateChatResponse(
        UUID id,

        String title,

        UUID advertisementId,

        UUID sellerId,

        UUID buyerId,

        Instant createdAt
) {
}
