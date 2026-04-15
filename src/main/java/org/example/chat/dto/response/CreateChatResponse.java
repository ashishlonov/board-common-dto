package org.example.chat.dto.response;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

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
