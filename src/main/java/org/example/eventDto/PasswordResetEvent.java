package org.example.eventDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Пользователь запросил сброс пароля.
 *
 * <p>Поля: email — email пользователя, resetToken — токен для сброса пароля.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PasswordResetEvent {
    private String email;
    private String resetToken;
}
