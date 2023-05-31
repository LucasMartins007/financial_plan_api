package com.lucas.github.financial_planning.utils;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

    private StringUtil() {
    }

    /**
     * @param value String that will be verified
     * @return if the string value is null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.equals("")  || value.trim().isEmpty() || value.equalsIgnoreCase("null");
    }

    public static boolean isNullOrEmpty(Object value) {
        return value == null || value.toString().trim().isEmpty();
    }

    /**
     * @param value String that will be verified
     * @return if the string valur is not null or empty
     */
    public static boolean isNotNullOrEmpty(String value) {
        return !isNullOrEmpty(value);
    }
}
