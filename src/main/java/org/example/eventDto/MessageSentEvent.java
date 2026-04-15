package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Сообщение отправлено в чате.
 *
 * @param messageId       ID сообщения
 * @param senderId        ID отправителя
 * @param receiverId      ID получателя
 * @param advertisementId ID объявления, к которому привязан чат
 * @param messageText     текст сообщения
 */
@Builder
public record MessageSentEvent(
        UUID messageId,
        UUID senderId,
        UUID receiverId,
        UUID advertisementId,
        String messageText
) {
}
