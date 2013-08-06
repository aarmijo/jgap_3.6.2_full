/*
 * ForecastDay.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: ForecastDay.java 09-01-2012 16:43:03 ttravnicek
 */
public class ForecastDayExtended extends ForecastDay {

    private Date date;
    private HighLow high;
    private HighLow low;
    private String conditions;
    private String skyicon;
    private Gpf qpf_allday;
    private Gpf qpf_day;
    private Gpf qpf_night;
    private Gpf snow_allday;
    private Gpf snow_day;
    private Gpf snow_night;
    private Wind maxwind;
    private Wind avewind;
    private int avehumidity;
    private int maxhumidity;
    private int minhumidity;

    /**
     * 
     * @return
     */
    public int getAvehumidity() {
        return avehumidity;
    }

    /**
     * 
     * @return
     */
    public Wind getAvewind() {
        return avewind;
    }

    /**
     * 
     * @return
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     * @return
     */
    public HighLow getHigh() {
        return high;
    }

    /**
     * 
     * @return
     */
    public HighLow getLow() {
        return low;
    }

    /**
     * 
     * @return
     */
    public int getMaxhumidity() {
        return maxhumidity;
    }

    /**
     * 
     * @return
     */
    public Wind getMaxwind() {
        return maxwind;
    }

    /**
     * 
     * @return
     */
    public int getMinhumidity() {
        return minhumidity;
    }

    /**
     * 
     * @return
     */
    public Gpf getQpf_allday() {
        return qpf_allday;
    }

    /**
     * 
     * @return
     */
    public Gpf getQpf_day() {
        return qpf_day;
    }

    /**
     * 
     * @return
     */
    public Gpf getQpf_night() {
        return qpf_night;
    }

    /**
     * 
     * @return
     */
    public String getSkyicon() {
        return skyicon;
    }

    /**
     * 
     * @return
     */
    public Gpf getSnow_allday() {
        return snow_allday;
    }

    /**
     * 
     * @return
     */
    public Gpf getSnow_day() {
        return snow_day;
    }

    /**
     * 
     * @return
     */
    public Gpf getSnow_night() {
        return snow_night;
    }
}
