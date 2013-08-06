/*
 * Observation.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.history;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Observation.java 27-01-2012 10:42:07 ttravnicek
 */
public class Observation {
    private Date date;
    private Date utcdate;
    private String tempm;
    private String tempi;
    private String dewptm;
    private String dewpti;
    private String hum;
    private String wspdm;
    private String wspdi;
    private String wgustm;
    private String wgusti;
    private String wdird;
    private String wdire;
    private String vism;
    private String visi;
    private String pressurem;
    private String pressurei;
    private String windchillm;
    private String windchilli;
    private String heatindexm;
    private String heatindexi;
    private String precipm;
    private String precipi;
    private String conds;
    private String icon;
    private String fog;
    private String rain;
    private String snow;
    private String hail;
    private String thunder;
    private String tornado;
    private String metar;

    public String getConds() {
        return conds;
    }

    public Date getDate() {
        return date;
    }

    public String getDewpti() {
        return dewpti;
    }

    public String getDewptm() {
        return dewptm;
    }

    public String getFog() {
        return fog;
    }

    public String getHail() {
        return hail;
    }

    public String getHeatindexi() {
        return heatindexi;
    }

    public String getHeatindexm() {
        return heatindexm;
    }

    public String getHum() {
        return hum;
    }

    public String getIcon() {
        return icon;
    }

    public String getMetar() {
        return metar;
    }

    public String getPrecipi() {
        return precipi;
    }

    public String getPrecipm() {
        return precipm;
    }

    public String getPressurei() {
        return pressurei;
    }

    public String getPressurem() {
        return pressurem;
    }

    public String getRain() {
        return rain;
    }

    public String getSnow() {
        return snow;
    }

    public String getTempi() {
        return tempi;
    }

    public String getTempm() {
        return tempm;
    }

    public String getThunder() {
        return thunder;
    }

    public String getTornado() {
        return tornado;
    }

    public Date getUtcdate() {
        return utcdate;
    }

    public String getVisi() {
        return visi;
    }

    public String getVism() {
        return vism;
    }

    public String getWdird() {
        return wdird;
    }

    public String getWdire() {
        return wdire;
    }

    public String getWgusti() {
        return wgusti;
    }

    public String getWgustm() {
        return wgustm;
    }

    public String getWindchilli() {
        return windchilli;
    }

    public String getWindchillm() {
        return windchillm;
    }

    public String getWspdi() {
        return wspdi;
    }

    public String getWspdm() {
        return wspdm;
    }
}
