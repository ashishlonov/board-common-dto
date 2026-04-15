package org.example.auction.dto.response;

import lombok.Builder;
import org.example.auction.dto.help.AuctionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Полный ответ с информацией об аукционе
 *
 * @param id                 уникальный идентификатор аукциона
 * @param advertisementId    ID привязанного объявления
 * @param ownerId            ID владельца аукциона
 * @param title              название
 * @param startPrice         стартовая цена
 * @param currentPrice       текущая цена (последняя ставка)
 * @param minBidStep         минимальный шаг ставки
 * @param status             статус аукциона
 * @param winnerId           ID победителя (если завершён)
 * @param startsAt           время начала торгов
 * @param endsAt             время окончания торгов
 * @param bidsCount          количество сделанных ставок
 * @param maxParticipants    максимальное число участников
 * @param currentParticipants текущее число участников
 * @param participantIds     ID всех участников
 */
@Builder
public record AuctionResponse(
        UUID          id,
        UUID advertisementId,
        UUID          ownerId,
        String        title,
        BigDecimal startPrice,
        BigDecimal    currentPrice,
        BigDecimal    minBidStep,
        AuctionStatus status,
        UUID          winnerId,
        Instant startsAt,
        Instant       endsAt,
        int           bidsCount,
        int           maxParticipants,
        int           currentParticipants,
        List<UUID>    participantIds
) {}