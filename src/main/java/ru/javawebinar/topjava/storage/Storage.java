package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Сергей on 21.01.2017.
 */
public interface Storage {
    void add(Meal meal);
    void add(List<Meal>list);
    void update(Long id, Meal meal);
    void delete(Long id);
    Meal get(Long id);
    List<Meal> getAll();

}
