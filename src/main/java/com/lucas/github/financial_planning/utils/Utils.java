package com.lucas.github.financial_planning.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    public static boolean isEmpty(Object obj) {
        return ObjectUtils.isEmpty(obj);
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
