package com.lucas.github.financial_planning.utils;

import com.lucas.github.financial_planning.pattern.enums.EnumDateFormat;

import java.util.Date;

public class DateUtils {

    private DateUtils() {
    }

    public static String formatDDMMYYYY(Date date) {
        return date != null ? EnumDateFormat.DDMMYYYY.getFormat().format(date) : "";
    }

    public static String formatDDMMYYYYHHMMSS(Date date) {
        return date != null ? EnumDateFormat.DDMMYYYYHHMMSS.getFormat().format(date) : "";
    }
}
