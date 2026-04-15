package org.example.auction.dto.help;

/**
 * Статусы жизненного цикла аукциона.
 *
 * <ul>
 *   <li><b>PENDING</b> - аукцион создан, но ещё не начался.</li>
 *
 *   <li><b>ACTIVE</b> - аукцион активен.</li>
 *
 *   <li><b>FINISHED</b> - аукцион завершён. Ставки больше не принимаются. Определён победитель.</li>
 *
 *   <li><b>CANCELLED</b> - аукцион отменён.</li>
 * </ul>
 */
public enum AuctionStatus {
    PENDING,
    ACTIVE,
    FINISHED,
    CANCELLED
}