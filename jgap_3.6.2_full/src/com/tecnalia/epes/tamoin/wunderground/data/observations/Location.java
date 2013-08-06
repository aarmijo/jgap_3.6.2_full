/*
 * Location.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.observations;

import com.tecnalia.epes.tamoin.wunderground.data.geolookup.NearbyWeatherStations;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Location.java 09-01-2012 16:19:58 ttravnicek
 */
public class Location {
    private String type;
    private String full;
    private String city;
    private String state;
    private String state_name;
    private String country;
    private String country_iso3166;
    private String country_name;
    private String zip;
    private String latitude;
    private String longitude;
    private String elevation;
    private String tz_short;
    private String tz_long;
    private String lat;
    private String lon;
    private String magic;
    private String wmo;
    private String l;
    private String requesturl;
    private String wuirl;
    private NearbyWeatherStations nearby_weather_stations;

    /**
     * 
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @return
     */
    public String getCountry_iso3166() {
        return country_iso3166;
    }

    /**
     * 
     * @return
     */
    public String getElevation() {
        return elevation;
    }

    /**
     * 
     * @return
     */
    public String getFull() {
        return full;
    }

    /**
     * 
     * @return
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @return
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @return
     */
    public String getState_name() {
        return state_name;
    }

    /**
     * 
     * @return
     */
    public String getZip() {
        return zip;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getL() {
        return l;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getMagic() {
        return magic;
    }

    public NearbyWeatherStations getNearby_weather_stations() {
        return nearby_weather_stations;
    }

    public String getRequesturl() {
        return requesturl;
    }

    public String getType() {
        return type;
    }

    public String getTz_long() {
        return tz_long;
    }

    public String getTz_short() {
        return tz_short;
    }

    public String getWmo() {
        return wmo;
    }

    public String getWuirl() {
        return wuirl;
    }
    
}
