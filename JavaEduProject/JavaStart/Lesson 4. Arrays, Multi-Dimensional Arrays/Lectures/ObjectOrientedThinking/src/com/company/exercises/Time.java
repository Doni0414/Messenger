package com.company.listings;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
    private long hour;
    private long minute;
    private long second;

    public Time(){
        long elapsedTime = System.currentTimeMillis();
        setTime(elapsedTime);
    }
    public Time(long elapsedTime){
        setTime(elapsedTime);
    }
    public Time(long hour, long minute, long second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setTime(long elapsedTime){
        Date date = new Date(elapsedTime);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        this.hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
        this.minute = calendar.get(GregorianCalendar.MINUTE);
        this.second = calendar.get(GregorianCalendar.SECOND);

    }
    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }
}
