package org.example.photo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.photo.validation.ValidImageFile;
import org.springframework.web.multipart.MultipartFile;

public class ImageFileValidator
        implements ConstraintValidator<ValidImageFile, MultipartFile> {

    private long maxSizeBytes;

    @Override
    public void initialize(ValidImageFile annotation) {
        this.maxSizeBytes = annotation.maxSizeBytes();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext ctx) {
        if (file == null || file.isEmpty()) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("Файл не может быть пустым").addConstraintViolation();
            return false;
        }

        if (file.getSize() > maxSizeBytes) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                            "Файл не должен превышать %dMB"
                                    .formatted(maxSizeBytes / 1024 / 1024))
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}