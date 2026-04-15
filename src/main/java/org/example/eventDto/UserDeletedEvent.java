package org.example.eventDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Пользователь удалён.
 *
 * <p>Поля: id — ID удалённого пользователя.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDeletedEvent {
    private UUID id;
}
