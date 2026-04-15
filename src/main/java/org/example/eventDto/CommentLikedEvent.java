package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CommentLikedEvent (
        UUID commentId,
        UUID commentAuthorId,  // кому отправить уведомление
        UUID likedByUserId,    // кто лайкнул
        String commentText
){
}
