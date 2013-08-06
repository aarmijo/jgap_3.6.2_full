/*
 * Planner.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.planner;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Planner.java 27-01-2012 10:59:47 ttravnicek
 */
public class Planner {
    private String title;
    private String airport_code;
    private String error;
    private Period period_of_record;
    private MinAvgMax temp_high;
    private MinAvgMax temp_low;
    private MinAvgMaxInCm precip;
    private MinAvgMax dewpoint_high;
    private MinAvgMax dewpoint_low;
    private CloudCover cloud_cover;
    private ChanceOf chance_of;

    public String getAirport_code() {
        return airport_code;
    }

    public ChanceOf getChance_of() {
        return chance_of;
    }

    public CloudCover getCloud_cover() {
        return cloud_cover;
    }

    public MinAvgMax getDewpoint_high() {
        return dewpoint_high;
    }

    public MinAvgMax getDewpoint_low() {
        return dewpoint_low;
    }

    public String getError() {
        return error;
    }

    public Period getPeriod_of_record() {
        return period_of_record;
    }

    public MinAvgMaxInCm getPrecip() {
        return precip;
    }

    public MinAvgMax getTemp_high() {
        return temp_high;
    }

    public MinAvgMax getTemp_low() {
        return temp_low;
    }

    public String getTitle() {
        return title;
    }
    
}
