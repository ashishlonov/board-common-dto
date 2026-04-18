package org.example.advertisement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.advertisement.dto.AttributeFilterDto;
import org.example.advertisement.dto.help.SortOption;
import org.example.advertisement.validation.ValidCostRange;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Поиск объявлений с фильтрами и пагинацией.
 *
 * <p>Поля: page — номер страницы (начиная с 0), size — размер страницы (1–100),
 * name — фильтр по названию, categorySlug — фильтр по slug категории,
 * costFrom — минимальная цена, costTo — максимальная цена,
 * isActive — фильтр по активности, ownerId — фильтр по владельцу,
 * includeDeleted — включать ли удалённые объявления,
 * attributes — фильтры по атрибутам,
 * sortBy — сортировка (по дате/цене, по возрастанию/убыванию).</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidCostRange
public class AdvertisementSearchRequest {
    @Min(value = 0, message = "Номер страницы не может быть отрицательным")
    private Integer page = 0;
    @Min(value = 1, message = "Размер страницы минимум 1")
    @Max(value = 100, message = "Размер страницы максимум 100")
    private Integer size = 20;
    @Size(max = 100, message = "Название не более 100 символов")
    private String name;
    @JsonProperty("category_slug")
    @Size(max = 100, message = "Slug не более 100 символов")
    @Pattern(
            regexp = "^$|^[a-z0-9]+(-[a-z0-9]+)*$",
            message = "Некорректный slug категории"
    )
    private String categorySlug;
    @JsonProperty("cost_from")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Минимальная цена не может быть отрицательной")
//    @Digits(integer = 10, fraction = 2,
//            message = "Некорректный формат минимальной цены")
    private Integer costFrom;
    @JsonProperty("cost_to")
    @DecimalMin(value = "0.0", inclusive = true,
            message = "Максимальная цена не может быть отрицательной")
//    @Digits(integer = 10, fraction = 2,
//            message = "Некорректный формат максимальной цены")
    private Integer costTo;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("owner_id")
    private UUID ownerId;
    @JsonProperty("include_deleted")
    private Boolean includeDeleted;
    @Valid
    private List<AttributeFilterDto> attributes;
    @JsonProperty("sort_by")
    private SortOption sortBy = SortOption.DATE_DESC;
}
