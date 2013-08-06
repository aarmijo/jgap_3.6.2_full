/*
 * Wind.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.forecast;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Wind.java 09-01-2012 17:02:25 ttravnicek
 */
public class Wind {
    private int mph;
    private int kph;
    private String dir;
    private int degrees;

    /**
     * 
     * @return
     */
    public int getDegrees() {
        return degrees;
    }

    /**
     * 
     * @return
     */
    public String getDir() {
        return dir;
    }

    /**
     * 
     * @return
     */
    public int getKph() {
        return kph;
    }

    /**
     * 
     * @return
     */
    public int getMph() {
        return mph;
    }
}
