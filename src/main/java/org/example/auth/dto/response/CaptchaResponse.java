package org.example.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Ответ с данными капчи для отрисовки на клиенте
 *
 * @param captchaToken  токен капчи (отправляется обратно при регистрации)
 * @param image         изображение капчи (base64 или URL)
 */
@Builder
public record CaptchaResponse (
        @JsonProperty("captcha_token")
        String captchaToken,
        String image
) {
}
