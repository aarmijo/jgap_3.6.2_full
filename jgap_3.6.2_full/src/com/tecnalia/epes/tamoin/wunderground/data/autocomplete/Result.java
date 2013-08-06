/*
 * Result.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.autocomplete;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Result.java 27-01-2012 9:30:44 ttravnicek
 */
public class Result {
    private String name;
    private String type;
    private String date;
    private String strnum;
    private String basin;
    private String damage;
    private String c;
    private String zmw;
    private String tz;
    private String tzs;
    private String l;

    public String getBasin() {
        return basin;
    }

    public String getC() {
        return c;
    }

    public String getDamage() {
        return damage;
    }

    public String getDate() {
        return date;
    }

    public String getL() {
        return l;
    }

    public String getName() {
        return name;
    }

    public String getStrnum() {
        return strnum;
    }

    public String getType() {
        return type;
    }

    public String getTz() {
        return tz;
    }

    public String getTzs() {
        return tzs;
    }

    public String getZmw() {
        return zmw;
    }
}
