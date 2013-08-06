/*
 * PWSStation.java
 * 
 * Created on 13-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.geolookup;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: PWSStation.java 13-01-2012 15:41:19 ttravnicek
 */
public class PWSStation {
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String id;
    private String distance_km;
    private String distance_mi;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDistance_km() {
        return distance_km;
    }

    public String getDistance_mi() {
        return distance_mi;
    }

    public String getId() {
        return id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }
}
