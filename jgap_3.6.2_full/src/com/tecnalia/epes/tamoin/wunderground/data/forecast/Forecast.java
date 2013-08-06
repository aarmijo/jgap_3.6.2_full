/*
 * Forecast.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Forecast.java 09-01-2012 16:39:05 ttravnicek
 */
public class Forecast {
    private TxtForecast txt_forecast;
    private SimpleForecast simpleforecast;

    /**
     * 
     * @return
     */
    public SimpleForecast getSimpleforecast() {
        return simpleforecast;
    }

    /**
     * 
     * @return
     */
    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }
}
