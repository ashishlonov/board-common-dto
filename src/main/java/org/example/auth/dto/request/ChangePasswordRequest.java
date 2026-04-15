package org.example.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.example.auth.validation.FieldsMatch;

/**
 * Запрос на смену пароля
 *
 * @param oldPassword  текущий пароль
 * @param newPassword  новый пароль (должен отличаться от старого)
 */
@Builder
@FieldsMatch(
        field = "oldPassword",
        fieldMatch = "newPassword",
        shouldMatch = false
)
public record ChangePasswordRequest (
        @NotBlank
        @JsonProperty("old_password")
        String oldPassword,
        @NotBlank
        @JsonProperty("new_password")
        String newPassword
){
}
