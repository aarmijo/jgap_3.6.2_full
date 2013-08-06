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
public class SimpleForecast {
    private List<ForecastDayExtended> forecastday;

    /**
     * 
     * @return
     */
    public List<ForecastDayExtended> getForecastday() {
        return forecastday;
    }
}
