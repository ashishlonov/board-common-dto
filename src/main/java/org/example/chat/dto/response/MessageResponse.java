package org.example.chat.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.chat.dto.help.ChatMessageStatus;

import java.time.Instant;
import java.util.UUID;

@Builder
public record MessageResponse(
        UUID id,

        @JsonProperty("sender_id")
        UUID senderId,

        String text,

        ChatMessageStatus status,

        @JsonProperty("sent_at")
        Instant sentAt,

        @JsonProperty("edited_at")
        Instant editedAt
) {
}
