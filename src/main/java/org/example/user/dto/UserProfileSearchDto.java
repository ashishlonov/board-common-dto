package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.user.dto.help.ProfileType;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileSearchDto {
    @Min(value = 0, message = "Страница не может быть отрицательной")
    @Builder.Default
    @Schema(example = "0", description = "Номер страницы (начиная с 0)")
    private int page = 0;
    @Min(value = 1, message = "Размер страницы минимум 1")
    @Max(value = 100, message = "Размер страницы максимум 100")
    @Builder.Default
    @Schema(example = "20", description = "Размер страницы")
    private int size = 20;

    @Schema(example = "Иван", description = "Поиск по имени")
    private String name;
    @Schema(example = "ООО Рога и Копыта", description = "Поиск по названию компании")
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("profile_type")
    @Schema(example = "COMPANY", description = "Тип профиля: PERSONAL или COMPANY")
    private ProfileType profileType;
    @JsonProperty("user_profile_id")
    private UUID userProfileId;
}
