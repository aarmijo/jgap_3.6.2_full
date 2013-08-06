/*
 * Date.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Date.java 09-01-2012 16:52:26 ttravnicek
 */
public class Date {
    private String epoch;
    private String pretty;
    private int day;
    private int month;
    private int year;
    private int yday;
    private int hour;
    private int min;
    private int sec;
    private String isdst;
    private String monthname;
    private String weekday_short;
    private String weekday;
    private String ampm;
    private String tz_short;
    private String tz_long;

    /**
     * 
     * @return
     */
    public String getAmpm() {
        return ampm;
    }

    /**
     * 
     * @return
     */
    public int getDay() {
        return day;
    }

    /**
     * 
     * @return
     */
    public String getEpoch() {
        return epoch;
    }

    /**
     * 
     * @return
     */
    public int getHour() {
        return hour;
    }

    /**
     * 
     * @return
     */
    public String getIsdst() {
        return isdst;
    }

    /**
     * 
     * @return
     */
    public int getMin() {
        return min;
    }

    /**
     * 
     * @return
     */
    public int getMonth() {
        return month;
    }

    /**
     * 
     * @return
     */
    public String getMonthname() {
        return monthname;
    }

    /**
     * 
     * @return
     */
    public String getPretty() {
        return pretty;
    }

    /**
     * 
     * @return
     */
    public int getSec() {
        return sec;
    }

    /**
     * 
     * @return
     */
    public String getTz_long() {
        return tz_long;
    }

    /**
     * 
     * @return
     */
    public String getTz_short() {
        return tz_short;
    }

    /**
     * 
     * @return
     */
    public String getWeekday() {
        return weekday;
    }

    /**
     * 
     * @return
     */
    public String getWeekday_short() {
        return weekday_short;
    }

    /**
     * 
     * @return
     */
    public int getYday() {
        return yday;
    }

    /**
     * 
     * @return
     */
    public int getYear() {
        return year;
    }
}
