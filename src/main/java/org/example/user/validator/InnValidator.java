package org.example.user.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.user.validation.ValidInn;

public class InnValidator
        implements ConstraintValidator<ValidInn, String> {

    @Override
    public boolean isValid(String inn, ConstraintValidatorContext ctx) {
        if (inn == null || inn.isBlank()) return true;

        // ЮЛ — 10 цифр, ИП — 12 цифр
        if (!inn.matches("\\d{10}|\\d{12}")) return false;

        return checkControlSum(inn);
    }

    private boolean checkControlSum(String inn) {
        int[] digits = inn.chars()
                .map(c -> c - '0')
                .toArray();

        if (inn.length() == 10) {
            int[] coef = {2,4,10,3,5,9,4,6,8};
            int sum = 0;
            for (int i = 0; i < 9; i++) sum += coef[i] * digits[i];
            return digits[9] == (sum % 11) % 10;
        }

        // для 12-значного ИНН (ИП) — два контрольных числа
        int[] c1 = {7,2,4,10,3,5,9,4,6,8};
        int[] c2 = {3,7,2,4,10,3,5,9,4,6,8};
        int s1 = 0, s2 = 0;
        for (int i = 0; i < 10; i++) s1 += c1[i] * digits[i];
        for (int i = 0; i < 11; i++) s2 += c2[i] * digits[i];
        return digits[10] == (s1 % 11) % 10
                && digits[11] == (s2 % 11) % 10;
    }
}