/*
 * Result.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.response;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Result.java 27-01-2012 9:30:44 ttravnicek
 */
public class Result {
    private String name;
    private String city;
    private String state;
    private String country;
    private String country_iso3166;
    private String country_name;
    private String zmw;
    private String l;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_iso3166() {
        return country_iso3166;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getL() {
        return l;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getZmw() {
        return zmw;
    }
    
}
