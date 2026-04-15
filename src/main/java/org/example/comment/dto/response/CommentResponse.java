package org.example.comment.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.user.dto.ShortUserDto;

import java.time.Instant;
import java.util.UUID;

/**
 * Полный ответ с информацией о комментарии
 *
 * @param id                 уникальный идентификатор
 * @param text               текст комментария
 * @param likesCount         количество лайков
 * @param parentId           ID родительского комментария (для вложенных)
 * @param isDeleted          удалён ли комментарий
 * @param repliesCount       количество ответов
 * @param depth              глубина вложенности
 * @param isEdited           редактировался ли комментарий
 * @param updatedAt          время последнего редактирования
 * @param createdAt          время создания
 * @param author             данные автора
 * @param advertisementId    ID объявления, к которому оставлен комментарий
 * @param likedByCurrentUser  лайкнул ли текущий пользователь
 */
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
