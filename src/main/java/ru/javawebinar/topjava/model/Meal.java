package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.ThreadSafeCounter;

import java.time.LocalDateTime;

/**
 * Created by Сергей on 21.01.2017.
 */
public class Meal {
    private final Long id;
    private final LocalDateTime dateTime;
    private final String description;
    private final int calories;


    public Meal(Long id,LocalDateTime dateTime, String description, int calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.id = ThreadSafeCounter.getAndIncreament();
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
}
