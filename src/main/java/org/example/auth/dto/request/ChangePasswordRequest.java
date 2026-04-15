package org.example.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.example.auth.validation.FieldsMatch;

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
