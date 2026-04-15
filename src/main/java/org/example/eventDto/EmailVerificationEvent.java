package org.example.eventDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Пользователю нужно подтвердить email.
 *
 * <p>Поля: id — ID пользователя, email — email для подтверждения, emailToken — токен подтверждения.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailVerificationEvent {
    private UUID id;
    private String email;
    private String emailToken;
}
