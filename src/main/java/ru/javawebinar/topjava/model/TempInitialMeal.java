package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Сергей on 21.01.2017.
 */
public class TempInitialMeal {
    private static List<Meal> mealList = Arrays.asList(
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 21, 8, 0), "завтрак", 500),
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 21, 12, 0), "обед", 1000),
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 21, 18, 0), "ужин", 500),
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 22, 8, 0), "завтрак", 600),
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 22, 12, 0), "обед", 1100),
            new Meal(LocalDateTime.of(2017, Month.JANUARY, 22, 18, 0), "ужин", 600));

    public static List<Meal> get() {
        return mealList;
    }

}
