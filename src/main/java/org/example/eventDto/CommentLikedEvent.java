package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Комментарий лайкнут — для отправки уведомления автору.
 *
 * @param commentId        ID комментария
 * @param commentAuthorId  ID автора комментария (кому отправить уведомление)
 * @param likedByUserId    ID пользователя, который лайкнул
 * @param commentText      текст комментария
 */
@Builder
public record CommentLikedEvent (
        UUID commentId,
        UUID commentAuthorId,  // кому отправить уведомление
        UUID likedByUserId,    // кто лайкнул
        String commentText
){
}
