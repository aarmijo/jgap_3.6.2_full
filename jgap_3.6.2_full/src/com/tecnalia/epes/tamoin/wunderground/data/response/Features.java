/*
 * Features.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.response;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Features.java 09-01-2012 15:54:42 ttravnicek
 */
public class Features {
    private int geolookup;
    private int conditions;
    private int forecast;
    private int astronomy;
    private int radar;
    private int satellite;
    private int webcams;
    private int history;
    private int alerts;
    private int hourly;
    private int hourly7day;
    private int forecast7day;
    private int yesterday;
    private int planner;
    private int autocomplete;
    private int almanac;
    private int lang;

    @Override
    public String toString() {
        return "Features: conditions "+conditions+", forecast"+forecast;
    }

    /**
     * 
     * @return
     */
    public int getAlerts() {
        return alerts;
    }

    /**
     * 
     * @return
     */
    public int getAlmanac() {
        return almanac;
    }

    /**
     * 
     * @return
     */
    public int getAstronomy() {
        return astronomy;
    }

    /**
     * 
     * @return
     */
    public int getAutocomplete() {
        return autocomplete;
    }

    /**
     * 
     * @return
     */
    public int getConditions() {
        return conditions;
    }

    /**
     * 
     * @return
     */
    public int getForecast() {
        return forecast;
    }

    /**
     * 
     * @return
     */
    public int getForecast7day() {
        return forecast7day;
    }

    /**
     * 
     * @return
     */
    public int getGeolookup() {
        return geolookup;
    }

    /**
     * 
     * @return
     */
    public int getHistory() {
        return history;
    }

    /**
     * 
     * @return
     */
    public int getHourly() {
        return hourly;
    }

    /**
     * 
     * @return
     */
    public int getHourly7day() {
        return hourly7day;
    }

    /**
     * 
     * @return
     */
    public int getLang() {
        return lang;
    }

    /**
     * 
     * @return
     */
    public int getPlanner() {
        return planner;
    }

    /**
     * 
     * @return
     */
    public int getRadar() {
        return radar;
    }

    /**
     * 
     * @return
     */
    public int getSatellite() {
        return satellite;
    }

    /**
     * 
     * @return
     */
    public int getWebcams() {
        return webcams;
    }

    /**
     * 
     * @return
     */
    public int getYesterday() {
        return yesterday;
    }
    
}
