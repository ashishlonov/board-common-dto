package org.example.comment.dto.help;

/**
 * Статусы комментария (модерация и видимость).
 *
 * <ul>
 *   <li><b>VISIBLE</b> - комментарий виден всем пользователям.</li>
 *   <li><b>HIDDEN</b> - комментарий скрыт модератором.</li>
 *   <li><b>PENDING_REVIEW</b> - комментарий ожидает проверки модератором.</li>
 *   <li><b>DELETED</b> - комментарий удалён администратором.</li>
 *   <li><b>USER_DELETED</b> - комментарий удалён автором.</li>
 * </ul>
 */
public enum CommentStatus {
    VISIBLE, HIDDEN, PENDING_REVIEW, DELETED, USER_DELETED
}