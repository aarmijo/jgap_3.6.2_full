/*
 * MinAvgMaxInCm.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.planner;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: MinAvgMaxInCm.java 27-01-2012 11:07:50 ttravnicek
 */
public class MinAvgMaxInCm {
    private InCm min;
    private InCm avg;
    private InCm max;

    public InCm getAvg() {
        return avg;
    }

    public InCm getMax() {
        return max;
    }

    public InCm getMin() {
        return min;
    }
}
