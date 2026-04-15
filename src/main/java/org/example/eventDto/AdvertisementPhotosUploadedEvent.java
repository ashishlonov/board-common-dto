package org.example.eventDto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AdvertisementPhotosUploadedEvent (
        UUID advertisementId,
        int count,
        String primaryPhotoPublicId
){
}