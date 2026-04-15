package org.example.advertisement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CategoryImportResultResponse(
        @JsonProperty("count_created")
        int countCreated,
        String status
) {

}
