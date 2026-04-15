package org.example.chat.dto.help;

/**
 * Статусы сообщения в чате.
 *
 * <ul>
 *   <li><b>READ</b> - сообщение прочитано получателем.</li>
 *   <li><b>SENDING</b> - сообщение отправляется, ожидает доставки.</li>
 *   <li><b>UNREAD</b> - сообщение доставлено, но ещё не прочитано.</li>
 *   <li><b>ERROR</b> - ошибка при отправке сообщения.</li>
 * </ul>
 */
public enum ChatMessageStatus {
    READ, SENDING, UNREAD, ERROR
}
