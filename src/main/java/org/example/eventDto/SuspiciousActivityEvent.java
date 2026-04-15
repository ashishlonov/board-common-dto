package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SuspiciousActivityEvent (
        UUID userId,
        String email,
        String reason
) {

}