package org.example.advertisement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Результат импорта категорий
 *
 * @param countCreated  количество созданных категорий
 * @param status        статус операции
 */
@Builder
public record CategoryImportResultResponse(
        @JsonProperty("count_created")
        int countCreated,
        String status
) {

}
