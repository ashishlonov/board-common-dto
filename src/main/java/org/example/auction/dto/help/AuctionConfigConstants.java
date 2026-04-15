package org.example.auction.dto.help;

import java.util.Arrays;

/**
 * Константы для настройки аукционов.
 */
public final class AuctionConfigConstants {

    /** Допустимые значения максимального количества участников аукциона. */
    public static final int[] ALLOWED_MAX_PARTICIPANTS = {10, 25, 50, 100};

    /** За сколько часов до начала аукциона закрывается подписка. */
    public static final long SUBSCRIPTION_CUTOFF_HOURS = 24;

    public static final long UPDATE_CUTOFF_HOURS = 48;

    private AuctionConfigConstants() {
    }

    public static boolean isValidMaxParticipants(int value) {
        return Arrays.stream(ALLOWED_MAX_PARTICIPANTS).anyMatch(v -> v == value);
    }
}
