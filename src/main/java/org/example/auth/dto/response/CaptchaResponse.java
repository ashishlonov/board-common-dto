package org.example.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CaptchaResponse (
        @JsonProperty("captcha_token")
        String captchaToken,
        String image
) {
}
