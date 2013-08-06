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
public class ForecastDay {

    /**
     * 
     */
    protected String period;
    /**
     * 
     */
    protected String icon;
    /**
     * 
     */
    protected String icon_url;
    /**
     * 
     */
    protected String title;
    /**
     * 
     */
    protected String fcttext;
    /**
     * 
     */
    protected String fcttext_metric;
    /**
     * 
     */
    protected String pop;

    /**
     * 
     * @return
     */
    public String getFcttext() {
        return fcttext;
    }

    /**
     * 
     * @return
     */
    public String getFcttext_metric() {
        return fcttext_metric;
    }

    /**
     * 
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @return
     */
    public String getIcon_url() {
        return icon_url;
    }

    /**
     * 
     * @return
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 
     * @return
     */
    public String getPop() {
        return pop;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

}
