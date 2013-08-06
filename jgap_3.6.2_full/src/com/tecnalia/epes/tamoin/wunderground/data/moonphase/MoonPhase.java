/*
 * MoonPhase.java
 * 
 * Created on 10-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.moonphase;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: MoonPhase.java 10-01-2012 8:43:31 ttravnicek
 */
public class MoonPhase {
    private int percentIlluminated;
    private int ageOfMoon;
    private Time current_time;
    private Time sunset;
    private Time sunrise;

    /**
     * 
     * @return
     */
    public int getAgeOfMoon() {
        return ageOfMoon;
    }

    /**
     * 
     * @return
     */
    public Time getCurrent_time() {
        return current_time;
    }

    /**
     * 
     * @return
     */
    public int getPercentIlluminated() {
        return percentIlluminated;
    }

    /**
     * 
     * @return
     */
    public Time getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @return
     */
    public Time getSunset() {
        return sunset;
    }
}
