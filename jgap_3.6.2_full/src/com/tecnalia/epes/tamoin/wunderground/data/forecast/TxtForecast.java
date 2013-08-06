/*
 * TxtForecast.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

import java.util.List;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: TxtForecast.java 09-01-2012 16:41:27 ttravnicek
 */
public class TxtForecast {
    private String date;
    private List<ForecastDay> forecastday;

    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @return
     */
    public List<ForecastDay> getForecastday() {
        return forecastday;
    }
}
