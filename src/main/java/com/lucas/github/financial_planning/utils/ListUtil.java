package com.lucas.github.financial_planning.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ListUtil {

    ListUtil(){
    }

    public static boolean isNullOrEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotNullOrNotEmpty(Collection<?> list) {
        return !isNullOrEmpty(list);
    }

    public static <E> E first(Collection<E> list) {
        if (isNotNullOrNotEmpty(list)) {
            return list.iterator().next();
        }
        return null;
    }

    public static <E> E last(Collection<E> list) {
        E last = null;

        if (isNotNullOrNotEmpty(list)) {
            for (E e : list) {
                last = e;
            }
        }

        return last;
    }

    public static <T> List<T> toList(T... values) {
        return Arrays.asList(values);
    }

    public static Integer size(Collection<?> items) {
        return items == null ? 0 : items.size();
    }

    public static <T> Stream<T> stream(Collection<T> lista) {
        return isNullOrEmpty(lista)
                ? Stream.empty()
                : lista.stream();
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(List<T> list) {
        return list.toArray((T[]) Array.newInstance(list.iterator().next().getClass(), 0));
    }



}
