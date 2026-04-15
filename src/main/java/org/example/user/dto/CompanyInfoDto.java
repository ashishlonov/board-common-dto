package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.user.dto.help.CompanyStatus;

public record CompanyInfoDto(
        String        inn,
        String        name,
        CompanyStatus status,
        @JsonProperty("status_message")
        String        statusMessage
) {
    public static CompanyInfoDto unknown(String inn) {
        return new CompanyInfoDto(
                inn, null,
                CompanyStatus.UNKNOWN,
                CompanyStatus.UNKNOWN.getDescription()
        );
    }
}
