package com.lucas.github.financial_planning.exception;

import com.lucas.github.financial_planning.utils.DateUtils;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

public class MessageExceptionFormatter {

    private MessageExceptionFormatter() {
    }

    public static String getMessage(String message, Object... arguments) {
        formatArgument(arguments);
        return MessageFormat.format(message, arguments);
    }

    private static void formatArgument(Object[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i] != null) {
                formatArgumentsOfListType(arguments, i);
                formatArgumentsOfDateType(arguments, i);
                continue;
            }
            arguments[i] = " ";
        }
    }

    private static void formatArgumentsOfDateType(Object[] arguments, int i) {
        if (arguments[i] instanceof Timestamp) {
            arguments[i] = DateUtils.formatDDMMYYYYHHMMSS((Date) arguments[i]);
        }
        if (arguments[i] instanceof Date date) {
            arguments[i] = DateUtils.formatDDMMYYYY(date);
        }
    }

    private static void formatArgumentsOfListType(Object[] arguments, int i) {
        if (arguments[i] instanceof List<?>) {
            StringBuilder retorno = new StringBuilder();

            for (Object s : (List<?>) arguments[i]) {
                retorno.append(s).append("\r\n");
            }
            arguments[i] = retorno.toString();
        }
    }

}
