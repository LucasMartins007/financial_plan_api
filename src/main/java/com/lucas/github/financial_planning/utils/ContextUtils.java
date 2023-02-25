package com.lucas.github.financial_planning.utils;

import com.lucas.github.financial_planning.context.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

public class ContextUtils  {

    private ContextUtils() {
    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ContextUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(Class<T> requiredType, Object... args) {
        return getApplicationContext().getBean(requiredType, args);
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationContextProvider.getApplicationContext();
    }

}
