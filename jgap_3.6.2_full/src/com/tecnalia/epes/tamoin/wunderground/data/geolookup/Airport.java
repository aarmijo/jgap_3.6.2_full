/*
 * Airport.java
 * 
 * Created on 13-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.geolookup;

import java.util.List;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Airport.java 13-01-2012 15:36:55 ttravnicek
 */
public class Airport {
    private List<AirportStation> station;

    public List<AirportStation> getStation() {
        return station;
    }
}
