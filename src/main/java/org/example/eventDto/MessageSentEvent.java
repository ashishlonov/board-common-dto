package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record MessageSentEvent(
        UUID messageId,
        UUID senderId,
        UUID receiverId,
        UUID advertisementId,
        String messageText
) {
}
