package org.example.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record ShortUserDto(
        UUID id,
        String name,
        @JsonProperty("phone_number")
        String phoneNumber,
        @JsonProperty("company_name")
        String companyName,
        @JsonProperty("profile_type")
        String profileType,
        @JsonProperty("company_status")
        String companyStatus,
        //toDo ::: не возвращает плюс получать номер?
        @JsonProperty("advertisement_count")
        Integer advertisementsCount,
        @JsonProperty("avatar_url")
        String avatarUrl,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("deleted_at")
        Instant deletedAt
) {

}
