package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

/**
 * Фотографии загружены для объявления.
 *
 * @param advertisementId       ID объявления
 * @param count                 количество загруженных фото
 * @param primaryPhotoPublicId  публичный ID главного фото в Cloudinary
 */
@Builder
public record AdvertisementPhotosUploadedEvent (
        UUID advertisementId,
        int count,
        String primaryPhotoPublicId
){
}