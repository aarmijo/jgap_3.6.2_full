/*
 * MinAvgMax.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.planner;

import com.tecnalia.epes.tamoin.wunderground.data.almanac.Normal;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: MinAvgMax.java 27-01-2012 11:05:09 ttravnicek
 */
public class MinAvgMax {
    private Normal min;
    private Normal avg;
    private Normal max;

    public Normal getAvg() {
        return avg;
    }

    public Normal getMax() {
        return max;
    }

    public Normal getMin() {
        return min;
    }
}
