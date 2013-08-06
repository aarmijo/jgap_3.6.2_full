/*
 * Response.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.response;

import java.util.List;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: Response.java 09-01-2012 15:52:33 ttravnicek
 */
public class Response {
    
    private String version;
    private String termsofService;
    private Features features;
    private List<Result> results;

    @Override
    public String toString() {
        return "Version: "+version+", terms: "+termsofService+", "+features.toString();
    }

    /**
     * 
     * @return
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * 
     * @return
     */
    public String getTermsofService() {
        return termsofService;
    }

    /**
     * 
     * @return
     */
    public String getVersion() {
        return version;
    }

    public List<Result> getResults() {
        return results;
    }
    
}
