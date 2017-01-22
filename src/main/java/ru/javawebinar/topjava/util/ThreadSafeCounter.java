package ru.javawebinar.topjava.util;

import java.util.spi.LocaleNameProvider;

/**
 * Created by Сергей on 21.01.2017.
 */
public class ThreadSafeCounter {
    private static Long id = Long.valueOf(0);

    public static synchronized Long getAndIncreament() {
        Long id1 = id;
        id++;
        return id1;
    }
}
