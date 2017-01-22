package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.ThreadSafeCounter;

import java.time.LocalDateTime;

/**
 * Created by Сергей on 21.01.2017.
 */
public class MealWithExceed {
    private final Long id;
    private final LocalDateTime dateTime;
    private final String description;
    private final int calories;
    private final boolean isExceed;

    public MealWithExceed(Meal meal, boolean isExceed) {
    this(meal.getId(),meal.getDateTime(),meal.getDescription(),meal.getCalories(),isExceed);
    }

    public MealWithExceed(Long id, LocalDateTime dateTime, String description, int calories, boolean isExceed) {
        this.isExceed = isExceed;
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExceed() {
        return isExceed;
    }

    @Override
    public String toString() {
        return "MealWithExceed{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", isExceed=" + isExceed +
                '}';
    }
}
