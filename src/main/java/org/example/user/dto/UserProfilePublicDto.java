package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.advertisement.dto.AdvertisementShortDto;
import org.example.user.dto.help.CompanyStatus;
import org.example.user.dto.help.ProfileType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Публичный профиль пользователя — отображается на странице пользователя
 *
 * @param id                   уникальный идентификатор
 * @param name                 имя пользователя
 * @param profileType          тип профиля: личный или компания
 * @param companyName          название компании (для COMPANY)
 * @param contactName          контактное лицо
 * @param inn                  ИНН компании
 * @param companyStatus        статус компании из ФНС
 * @param companyStatusMessage пояснение к статусу компании
 * @param phoneNumber          номер телефона
 * @param avatarUrl            URL аватара
 * @param createdAt            время регистрации
 * @param updatedAt            время последнего обновления
 * @param deletedAt            время удаления (если удалён)
 * @param advertisements       список объявлений пользователя
 */
@Builder
public record UserProfilePublicDto (
        UUID id,
        String name,
        @JsonProperty("profile_type")
        ProfileType profileType,
        @JsonProperty("company_name")
        String companyName,
        @JsonProperty("contact_name")
        String contactName,
        String inn,
        @JsonProperty("company_status")
        CompanyStatus companyStatus,
        @JsonProperty("company_status_message")
        String companyStatusMessage,
        @JsonProperty("phone_number")
        String phoneNumber,
        @JsonProperty("avatar_url")
        String avatarUrl,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("updated_at")
        Instant updatedAt,
        @JsonProperty("deleted_at")
        Instant deletedAt,
        List<AdvertisementShortDto> advertisements
) {

}
