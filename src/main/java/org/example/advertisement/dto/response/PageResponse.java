package org.example.advertisement.dto.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {
    public static <T> PageResponse<T> of(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
    }
    public static <T> PageResponse<T> empty(Pageable pageable) {
        return new PageResponse<>(
                List.of(),
                pageable.getPageNumber(),
                pageable.getPageSize(),
                0L,
                0,
                true
        );
    }
}