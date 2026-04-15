package org.example.auth.dto.response;

import java.util.UUID;

public record RoleDto(
        UUID id,
        String name
) {}
