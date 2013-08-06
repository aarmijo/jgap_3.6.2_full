/*
 * History.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.history;

import java.util.List;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: History.java 27-01-2012 10:36:09 ttravnicek
 */
public class History {
    private Date date;
    private Date utcdate;
    private List<Observation> observations;

    public Date getDate() {
        return date;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public Date getUtcdate() {
        return utcdate;
    }
    
}
