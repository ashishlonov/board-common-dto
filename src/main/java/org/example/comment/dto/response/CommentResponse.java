package org.example.comment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.user.dto.ShortUserDto;

import java.time.Instant;
import java.util.UUID;

@Builder
public record CommentResponse(
        UUID id,
        String text,
        @JsonProperty("likes_count")
        Integer likesCount,
        @JsonProperty("parent_id")
        UUID parentId,
        @JsonProperty("is_deleted")
        Boolean isDeleted,
        @JsonProperty("replies_count")
        Integer repliesCount,
        Integer depth,
        @JsonProperty("is_edited")
        Boolean isEdited,
        @JsonProperty("updated_at")
        Instant updatedAt,
        @JsonProperty("created_at")
        Instant createdAt,
        @JsonProperty("author")
        ShortUserDto author,
        @JsonProperty("advertisement_id")
        UUID advertisementId,
        @JsonProperty("liked_by_current_user")
        Boolean likedByCurrentUser
) {
}
