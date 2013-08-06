/*
 * Satellite.java
 * 
 * Created on 13-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.satellite;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: Satellite.java 13-01-2012 16:18:30 ttravnicek
 */
public class Satellite {
    private String image_url;
    private String image_url_ir4;
    private String image_url_vis;

    public String getImage_url() {
        return image_url;
    }

    public String getImage_url_ir4() {
        return image_url_ir4;
    }

    public String getImage_url_vis() {
        return image_url_vis;
    }
}
