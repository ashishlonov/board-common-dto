package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Обнаружена подозрительная активность — для уведомления администратора.
 *
 * @param userId  ID пользователя
 * @param email   email пользователя
 * @param reason  причина подозрения
 */
@Builder
public record SuspiciousActivityEvent (
        UUID userId,
        String email,
        String reason
) {

}