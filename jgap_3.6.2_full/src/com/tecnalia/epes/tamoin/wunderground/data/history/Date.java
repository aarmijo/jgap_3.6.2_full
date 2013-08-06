/*
 * Date.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.history;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Date.java 27-01-2012 10:38:26 ttravnicek
 */
public class Date {
    private String pretty;
    private String year;
    private String mon;
    private String mday;
    private String hour;
    private String min;
    private String tzname;

    public String getHour() {
        return hour;
    }

    public String getMday() {
        return mday;
    }

    public String getMin() {
        return min;
    }

    public String getMon() {
        return mon;
    }

    public String getPretty() {
        return pretty;
    }

    public String getTzname() {
        return tzname;
    }

    public String getYear() {
        return year;
    }
    
}
