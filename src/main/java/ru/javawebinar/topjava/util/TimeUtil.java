package ru.javawebinar.topjava.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Сергей on 21.01.2017.
 */
public class TimeUtil {
    private static DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm dd.MM.yy");
    public static boolean isBetween(LocalTime thisTime, LocalTime start, LocalTime end){
        return thisTime.compareTo(start)>=0&&thisTime.compareTo(end)<=0;
    }
    public static String dtToString(LocalDateTime ldt){
        String text=ldt.format(dateTimeFormatter);
        return text;
        //return "aaa";
    }
}
