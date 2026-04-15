package org.example.comment.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Поиск комментариев с фильтрами.
 *
 * <p>Поля: page — номер страницы (начиная с 0), size — размер страницы (1–100),
 * userId — фильтр по ID пользователя, textSearch — поиск по тексту комментария,
 * showOnlyDeleted — показать только удалённые комментарии,
 * advertisementOwnerId — фильтр по владельцу объявления,
 * advertisementIds — список ID объявлений (заполняется внутренне, игнорируется в JSON).</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentSearchRequest {
    @Min(value = 0, message = "Страница не может быть отрицательной")
    @Builder.Default
    @Schema(example = "0", description = "Номер страницы (начиная с 0)")
    private int page = 0;
    @Min(value = 1, message = "Размер страницы минус 1")
    @Max(value = 100, message = "Размер страницы максимум 100")
    @Builder.Default
    @Schema(example = "20", description = "Размер страницы")
    private int size = 20;

    @JsonProperty("user_id")
    @Schema(example = "", description = "Фильтр по ID пользователя-комментатора")
    private UUID userId;

    @JsonProperty("text_search")
    @Schema(example = "Товар", description = "Поиск по тексту комментария")
    private String textSearch;

    @JsonProperty("show_only_deleted")
    @Schema(example = "false", description = "Показать только удалённые комментарии")
    private Boolean showOnlyDeleted;

    @JsonProperty("advertisement_owner_id")
    @Schema(example = "", description = "Фильтр по владельцу объявления (через AdvertisementApi)")
    private UUID advertisementOwnerId;

    @JsonIgnore
    private java.util.List<UUID> advertisementIds;
}
