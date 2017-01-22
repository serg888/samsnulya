package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Сергей on 21.01.2017.
 */
public class MapStorage implements Storage {
    private Map<Long, Meal> mealMap = new ConcurrentHashMap<Long, Meal>();

    public MapStorage() {
    }

    @Override
    public void add(Meal meal) {
        mealMap.put(meal.getId(), meal);
    }

    @Override
    public void add(List<Meal> map) {
        for (Meal meal : map) {
            mealMap.put(meal.getId(), meal);
        }

    }

    @Override
    public void update(Long id, Meal meal) {
        add(meal);
    }

    @Override
    public void delete(Long id) {
        if(id!=null){
            if(mealMap.containsKey(id)){
                mealMap.remove(id);
            }
        }
    }

    @Override
    public Meal get(Long id) {
        if(id!=null){
            if(mealMap.containsKey(id)){
               return mealMap.get(id);
            }
        }
        return null;
    }

    @Override
    public List<Meal> getAll() {
        List<Meal>list=new ArrayList<>();
        for(Map.Entry<Long,Meal> entry:mealMap.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Meal>() {
            @Override
            public int compare(Meal o1, Meal o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });
        return list;
    }
}
