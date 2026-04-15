package org.example.user.dto.help;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * Статусы компании из ФНС (Федеральная налоговая служба).
 *
 * <ul>
 *   <li><b>ACTIVE</b> - компания активна и действует.</li>
 *   <li><b>PENDING_VERIFICATION</b> - документы отправлены на модерацию, ожидает проверки.</li>
 *   <li><b>LIQUIDATING</b> - компания в процессе ликвидации.</li>
 *   <li><b>LIQUIDATED</b> - компания ликвидирована.</li>
 *   <li><b>REORGANIZING</b> - компания в процессе реорганизации.</li>
 *   <li><b>BANKRUPT</b> - компания признана банкротом.</li>
 *   <li><b>UNKNOWN</b> - статус компании неизвестен.</li>
 * </ul>
 */
public enum CompanyStatus {

    ACTIVE("Действующее",           "Компания активна"),
    PENDING_VERIFICATION("На проверке", "Документы отправлены на модерацию"),
    LIQUIDATING("Ликвидируется",    "Компания в процессе ликвидации"),
    LIQUIDATED("Ликвидировано",     "Компания ликвидирована"),
    REORGANIZING("Реорганизация",   "Компания в процессе реорганизации"),
    BANKRUPT("Банкротство",         "Компания признана банкротом"),
    UNKNOWN("Неизвестно",           "Статус неизвестен");

    private final String fnsStatus;
    private final String description;

    CompanyStatus(String fnsStatus, String description) {
        this.fnsStatus   = fnsStatus;
        this.description = description;
    }

    @JsonValue
    public String getFnsStatus() {
        return fnsStatus;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CompanyStatus fromFns(String fnsStatus) {
        if (fnsStatus == null) return UNKNOWN;

        return Arrays.stream(values())
                .filter(s -> s.fnsStatus.equalsIgnoreCase(fnsStatus))
                .findFirst()
                .orElse(UNKNOWN);
    }

    public boolean isActive() {
        return this == ACTIVE;
    }

    public String getDescription() {
        return description;
    }
}