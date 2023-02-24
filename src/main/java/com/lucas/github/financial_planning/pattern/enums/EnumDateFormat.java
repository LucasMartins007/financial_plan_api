package com.lucas.github.financial_planning.pattern.enums;

import java.text.SimpleDateFormat;

public enum EnumDateFormat {

    DDMMYYYY(newThreadLocalSimpleDateFormat("dd/MM/yyyy")),
    DDMMYYYYHHMMSS(newThreadLocalSimpleDateFormat("dd/MM/yyyy HH:mm:ss")),;

    private final ThreadLocal<SimpleDateFormat> formatter;

    EnumDateFormat(final ThreadLocal<SimpleDateFormat> formatter) {
        this.formatter = formatter;
    }

    private static ThreadLocal<SimpleDateFormat> newThreadLocalSimpleDateFormat(final String frmtString) {
        return ThreadLocal.withInitial(() -> new SimpleDateFormat(frmtString));
    }

    public SimpleDateFormat getFormat() {
        return this.formatter.get();
    }

}
