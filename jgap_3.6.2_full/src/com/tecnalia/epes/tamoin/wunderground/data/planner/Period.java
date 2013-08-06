/*
 * Period.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.planner;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Period.java 27-01-2012 11:16:51 ttravnicek
 */
public class Period {
    private DateStartEnd date_start;
    private DateStartEnd date_end;

    public DateStartEnd getDate_end() {
        return date_end;
    }

    public DateStartEnd getDate_start() {
        return date_start;
    }

}
