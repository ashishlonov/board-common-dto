package org.example.eventDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Новый пользователь зарегистрировался.
 *
 * <p>Поля: id — ID пользователя, firstName — имя пользователя, phoneNumber — номер телефона.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisteredEvent {
    private UUID id;
    private String firstName;
    private String phoneNumber;
}
