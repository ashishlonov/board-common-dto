package org.example.user.dto.help;

/**
 * Статус заявки на верификацию компании.
 *
 * <ul>
 *   <li><b>PENDING</b> - заявка подана, ожидает рассмотрения администратором.</li>
 *   <li><b>APPROVED</b> - заявка одобрена, компания верифицирована.</li>
 *   <li><b>REJECTED</b> - заявка отклонена администратором.</li>
 * </ul>
 */
public enum VerificationStatus {
    PENDING("На рассмотрении"),
    APPROVED("Одобрено"),
    REJECTED("Отклонено");

    private final String description;

    VerificationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}