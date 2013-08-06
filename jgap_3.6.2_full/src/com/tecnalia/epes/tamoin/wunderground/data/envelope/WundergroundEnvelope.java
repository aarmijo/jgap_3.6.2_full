/*
 * WundergroundGeneric.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.envelope;

import java.util.List;

import com.tecnalia.epes.tamoin.wunderground.data.alerts.Alert;
import com.tecnalia.epes.tamoin.wunderground.data.almanac.Almanac;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.Forecast;
import com.tecnalia.epes.tamoin.wunderground.data.history.History;
import com.tecnalia.epes.tamoin.wunderground.data.hourlyforecast.HourlyForecast;
import com.tecnalia.epes.tamoin.wunderground.data.moonphase.MoonPhase;
import com.tecnalia.epes.tamoin.wunderground.data.observations.CurrentObservation;
import com.tecnalia.epes.tamoin.wunderground.data.observations.Location;
import com.tecnalia.epes.tamoin.wunderground.data.planner.Planner;
import com.tecnalia.epes.tamoin.wunderground.data.radar.Radar;
import com.tecnalia.epes.tamoin.wunderground.data.response.Response;
import com.tecnalia.epes.tamoin.wunderground.data.satellite.Satellite;
import com.tecnalia.epes.tamoin.wunderground.data.webcams.Webcam;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: WundergroundGeneric.java 09-01-2012 16:11:00 ttravnicek
 */
public class WundergroundEnvelope {
    
    private Response response;
    private CurrentObservation current_observation;
    private Forecast forecast;
    private MoonPhase moon_phase;
    private List<HourlyForecast> hourly_forecast;
    private Almanac almanac;
    private Location location;
    private Radar radar;
    private Satellite satellite;
    private List<Webcam> webcams;
    private List<Alert> alerts;
    private History history;
    private Planner trip;

    @Override
    public String toString() {
        return response.toString();
    }

    /**
     * 
     * @return
     */
    public CurrentObservation getCurrent_observation() {
        return current_observation;
    }

    /**
     * 
     * @return
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     * 
     * @return
     */
    public MoonPhase getMoon_phase() {
        return moon_phase;
    }

    /**
     * 
     * @return
     */
    public Response getResponse() {
        return response;
    }

    public List<HourlyForecast> getHourly_forecast() {
        return hourly_forecast;
    }

    public Almanac getAlmanac() {
        return almanac;
    }

    public Location getLocation() {
        return location;
    }

    public Radar getRadar() {
        return radar;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public List<Webcam> getWebcams() {
        return webcams;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public History getHistory() {
        return history;
    }

    public Planner getTrip() {
        return trip;
    }

}
