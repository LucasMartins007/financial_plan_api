package com.lucas.github.financial_planning.validators;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CpfCnpjValidator {

    public static void validate(String cpfCnpj) {
        isValidCpfCnpj(cpfCnpj);
    }

    private static void isValidCpfCnpj(String cpfCnpj) {
        if (cpfCnpj.length() == 11) {
            validateCpf(cpfCnpj);
            return;
        }
        if (cpfCnpj.length() == 14) {
            validateCnpj(cpfCnpj);
            return;
        }
        throwException(cpfCnpj);
    }

    private static void throwException(String cpfCnpj) {
        throw new DomainRuntimeException(EnumMessagesException.INVALID_CPF_CNPJ, cpfCnpj);
    }

    private static void validateCpf(String cpf) {
        cpf = removeNonNumericCharacters(cpf);
        if (cpf.length() != 11) {
            throwException(cpf);
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = cpf.charAt(i) - '0';
        }

        if (hasAllSameDigits(digits)) {
            throwException(cpf);
        }

        int sum = 0;
        int factor = 10;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * factor;
            factor--;
        }

        int remainder = sum % 11;
        int firstCheckDigit = (remainder < 2) ? 0 : 11 - remainder;
        if (digits[9] != firstCheckDigit) {
            throwException(cpf);
        }

        sum = 0;
        factor = 11;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * factor;
            factor--;
        }

        remainder = sum % 11;
        int secondCheckDigit = (remainder < 2) ? 0 : 11 - remainder;
        if (digits[10] != secondCheckDigit) {
            throwException(cpf);
        }
    }

    private static void validateCnpj(String cnpj) {
        cnpj = removeNonNumericCharacters(cnpj);
        if (cnpj.length() != 14) {
            throwException(cnpj);
        }

        int[] digits = new int[14];
        for (int i = 0; i < 14; i++) {
            digits[i] = cnpj.charAt(i) - '0';
        }

        if (hasAllSameDigits(digits)) {
            throwException(cnpj);
        }

        int sum = 0;
        int factor = 5;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : factor - 1;
        }

        int remainder = sum % 11;
        int firstCheckDigit = (remainder < 2) ? 0 : 11 - remainder;
        if (digits[12] != firstCheckDigit) {
            throwException(cnpj);
        }

        sum = 0;
        factor = 6;
        for (int i = 0; i < 13; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : factor - 1;
        }

        remainder = sum % 11;
        int secondCheckDigit = (remainder < 2) ? 0 : 11 - remainder;
        if (digits[13] != secondCheckDigit) {
            throwException(cnpj);
        }
    }

    private static String removeNonNumericCharacters(String value) {
        return value.replaceAll("\\D", "");
    }

    private static boolean hasAllSameDigits(int[] digits) {
        int firstDigit = digits[0];
        for (int digit : digits) {
            if (digit != firstDigit) {
                return false;
            }
        }
        return true;
    }
}
