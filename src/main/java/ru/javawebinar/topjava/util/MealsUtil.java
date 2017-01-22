package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.model.TempInitialMeal;
import ru.javawebinar.topjava.storage.MapStorage;
import ru.javawebinar.topjava.storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Сергей on 21.01.2017.
 */
public class MealsUtil {

    public static void main(String[] args) {
        Storage storage=new MapStorage();
        storage.add(TempInitialMeal.get());
        //System.out.println(getFilteredWithExceed(storage.getAll(),LocalTime.of(5,0),LocalTime.of(10,0),2000));
        System.out.println(getFilteredWithExceed(storage.getAll(),2000));
    }
    public static List<MealWithExceed> getFilteredWithExceed(List<Meal>list,int calPerDay){
        return getFilteredWithExceed(list, LocalTime.MIN,LocalTime.MAX,calPerDay);
    }
    public static List<MealWithExceed> getFilteredWithExceed(List<Meal>list, LocalTime start, LocalTime end,int calPerDay){
        List<MealWithExceed>list1=new ArrayList<>();
        Map<LocalDate,Integer> caloriesCounter=new HashMap<>();
        for(Meal meal:list){
            LocalDate localDate=meal.getDateTime().toLocalDate();
            int cal=caloriesCounter.getOrDefault(localDate,0);
            caloriesCounter.put(localDate,cal+meal.getCalories());
        }
        for(Meal meal:list){
            if(TimeUtil.isBetween(meal.getDateTime().toLocalTime(),start,end)){
                list1.add(
                        new MealWithExceed(meal,caloriesCounter.get(meal.getDateTime().toLocalDate())>calPerDay));
            }
        }
        return list1;


    }
}
