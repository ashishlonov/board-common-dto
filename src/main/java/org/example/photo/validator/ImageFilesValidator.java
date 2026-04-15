package org.example.photo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.photo.validation.ValidImageFiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImageFilesValidator
        implements ConstraintValidator<ValidImageFiles, List<MultipartFile>> {

    private int  maxCount;
    private long maxSizeBytes;

    @Override
    public void initialize(ValidImageFiles annotation) {
        this.maxCount     = annotation.maxCount();
        this.maxSizeBytes = annotation.maxSizeBytes();
    }

    @Override
    public boolean isValid(List<MultipartFile> files, ConstraintValidatorContext ctx) {
        if (files == null || files.isEmpty()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("Список файлов не может быть пустым")
                    .addConstraintViolation();
            return false;
        }

        if (files.size() > maxCount) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("Максимум %d файлов за один запрос".formatted(maxCount))
                    .addConstraintViolation();
            return false;
        }

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);

            if (file == null || file.isEmpty()) {
                addError(ctx, i, "Файл не может быть пустым");
                return false;
            }

            if (file.getSize() > maxSizeBytes) {
                addError(ctx, i, "Файл не должен превышать %dMB"
                        .formatted(maxSizeBytes / 1024 / 1024));
                return false;
            }
        }

        return true;
    }

    private void addError(ConstraintValidatorContext ctx, int index, String message) {
        ctx.disableDefaultConstraintViolation();
        ctx.buildConstraintViolationWithTemplate(
                        "Файл[%d]: %s".formatted(index, message))
                .addConstraintViolation();
    }
}