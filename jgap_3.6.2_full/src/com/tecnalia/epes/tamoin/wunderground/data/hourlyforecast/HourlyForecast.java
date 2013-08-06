/*
 * HourlyForecast.java
 * 
 * Created on 11-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.hourlyforecast;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: HourlyForecast.java 11-01-2012 14:47:16 ttravnicek
 */
public class HourlyForecast {
    private FCTTime FCTTIME;
    private EnlishMetricUnit temp;
    private EnlishMetricUnit dewpoint;
    private String condition;
    private String icon;
    private String icon_url;
    private String fctcode;
    private String sky;
    private EnlishMetricUnit wspd;
    private WindDirection wdir;
    private String ws;
    private String uvi;
    private String humidity;
    private EnlishMetricUnit windchill;
    private EnlishMetricUnit headindex;
    private EnlishMetricUnit feelslike;
    private EnlishMetricUnit gpf;
    private EnlishMetricUnit show;
    private String pop;
}
