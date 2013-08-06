/*
 * AirportStation.java
 * 
 * Created on 13-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.geolookup;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: AirportStation.java 13-01-2012 15:39:12 ttravnicek
 */
public class AirportStation {
    private String city;
    private String state;
    private String country;
    private String icao;
    private String lat;
    private String lon;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIcao() {
        return icao;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getState() {
        return state;
    }
}
