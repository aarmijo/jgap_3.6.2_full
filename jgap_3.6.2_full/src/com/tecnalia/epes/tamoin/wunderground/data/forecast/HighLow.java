/*
 * HighLow.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: HighLow.java 09-01-2012 16:59:20 ttravnicek
 */
public class HighLow {
    private int fahrenheit;
    private int celsius;

    /**
     * 
     * @return
     */
    public int getCelsius() {
        return celsius;
    }

    /**
     * 
     * @return
     */
    public int getFahrenheit() {
        return fahrenheit;
    }
}
