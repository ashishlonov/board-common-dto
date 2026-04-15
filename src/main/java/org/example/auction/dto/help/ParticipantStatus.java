package org.example.auction.dto.help;

/**
 * Статусы участника аукциона.
 *
 * <ul>
 *   <li><b>SUBSCRIBED</b> - пользователь подписался на аукцион, но торги ещё не начались.</li>
 *   <li><b>ACTIVE</b> - аукцион активен, участник может делать ставки.</li>
 *   <li><b>ELIMINATED</b> - участник исключён из аукциона (отписался или нарушил правила).</li>
 * </ul>
 */
public enum ParticipantStatus {
    SUBSCRIBED,
    ACTIVE,
    ELIMINATED
}

