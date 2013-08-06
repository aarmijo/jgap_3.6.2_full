/*
 * Alert.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.alerts;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Alert.java 27-01-2012 10:04:29 ttravnicek
 */
public class Alert {
    private String type;
    private String wtype_meteoalarm;
    private String wtype_meteoalarm_name;
    private String level_meteoalarm;
    private String level_meteoalarm_name;
    private String level_meteoalarm_description;
    private String description;
    private String date;
    private String date_epoch;
    private String expires;
    private String expires_epoch;
    private String message;
    private String phenomena;
    private String significance;

    public String getDate() {
        return date;
    }

    public String getDate_epoch() {
        return date_epoch;
    }

    public String getDescription() {
        return description;
    }

    public String getExpires() {
        return expires;
    }

    public String getExpires_epoch() {
        return expires_epoch;
    }

    public String getLevel_meteoalarm() {
        return level_meteoalarm;
    }

    public String getLevel_meteoalarm_description() {
        return level_meteoalarm_description;
    }

    public String getLevel_meteoalarm_name() {
        return level_meteoalarm_name;
    }

    public String getMessage() {
        return message;
    }

    public String getPhenomena() {
        return phenomena;
    }

    public String getSignificance() {
        return significance;
    }

    public String getType() {
        return type;
    }

    public String getWtype_meteoalarm() {
        return wtype_meteoalarm;
    }

    public String getWtype_meteoalarm_name() {
        return wtype_meteoalarm_name;
    }
    
}
