package org.example.user.dto.help;

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