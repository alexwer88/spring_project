package ru.project.utils;

import java.util.Calendar;
import java.util.Date;


public class DateUtils {

    public static Date addDay(Date date, int countDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, countDay);
        return calendar.getTime();
    }

}
