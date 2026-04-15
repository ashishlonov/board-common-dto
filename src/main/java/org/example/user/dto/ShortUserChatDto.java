package org.example.user.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ShortUserChatDto(

        UUID id,

        String name,

        String avatarUrl
) {
}
