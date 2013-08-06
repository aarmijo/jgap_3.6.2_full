/*
 * Image.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.observations;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Image.java 09-01-2012 16:18:38 ttravnicek
 */
public class Image {
    private String url;
    private String title;
    private String link;

    /**
     * 
     * @return
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return
     */
    public String getUrl() {
        return url;
    }
}
