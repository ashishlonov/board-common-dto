package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.advertisement.dto.AdvertisementShortDto;
import org.example.user.dto.help.CompanyStatus;
import org.example.user.dto.help.ProfileType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

///toDO:::после такого как сделаю рейтинг систему нужно будет добавить сюда поле и отзывы
//добавитьь кучу всего например тот же самый  рейтинг  и тд

/// отдельный профиль
/// фото имя оценка дата осздания активные(не) объявления
///отзывы о продавце
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
