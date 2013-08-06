/*
 * Webcam.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.webcams;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Webcam.java 27-01-2012 9:57:06 ttravnicek
 */
public class Webcam {
    private String handle;
    private String camid;
    private String camindex;
    private String assoc_station_id;
    private String link;
    private String linktext;
    private String cameratype;
    private String organization;
    private String neighborhood;
    private String zip;
    private String city;
    private String state;
    private String country;
    private String tzname;
    private String lat;
    private String lon;
    private String updated;
    private String downloaded;
    private String isrecent;
    private String CURRENTIMAGEURL;
    private String WIDGETCURRENTIMAGEURL;
    private String CAMURL;

    public String getCAMURL() {
        return CAMURL;
    }

    public String getCURRENTIMAGEURL() {
        return CURRENTIMAGEURL;
    }

    public String getWIDGETCURRENTIMAGEURL() {
        return WIDGETCURRENTIMAGEURL;
    }

    public String getAssoc_station_id() {
        return assoc_station_id;
    }

    public String getCameratype() {
        return cameratype;
    }

    public String getCamid() {
        return camid;
    }

    public String getCamindex() {
        return camindex;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDownloaded() {
        return downloaded;
    }

    public String getHandle() {
        return handle;
    }

    public String getIsrecent() {
        return isrecent;
    }

    public String getLat() {
        return lat;
    }

    public String getLink() {
        return link;
    }

    public String getLinktext() {
        return linktext;
    }

    public String getLon() {
        return lon;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getOrganization() {
        return organization;
    }

    public String getState() {
        return state;
    }

    public String getTzname() {
        return tzname;
    }

    public String getUpdated() {
        return updated;
    }

    public String getZip() {
        return zip;
    }
    
}
