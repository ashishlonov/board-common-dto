package org.example.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Ответ с JWT-токенами после успешной авторизации
 *
 * @param accessToken   токен доступа (отправляется с каждым запросом)
 * @param refreshToken  токен обновления (используется для получения нового access_token)
 */
@Builder
public record TokenResponse (
    @JsonProperty("access_token")
    String accessToken,
    @JsonProperty("refresh_token")
    String refreshToken
) {}
