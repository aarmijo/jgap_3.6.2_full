/*
 * ChanceOf.java
 * 
 * Created on 27-01-2012
 * 
 * Copyright (C) 2012 Mailprofiler Development s.r.o., All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.planner;

/**
 *
 * @author Tomas Travnicek <tomas.travnicek at mailprofiler.com>
 * @version $Id: ChanceOf.java 27-01-2012 11:11:03 ttravnicek
 */
public class ChanceOf {

    private PercentageChanceOf tempoverfreezing;
    private PercentageChanceOf chanceofprecip;
    private PercentageChanceOf chanceofcloudyday;
    private PercentageChanceOf chanceofwindyday;
    private PercentageChanceOf chanceofsnowday;
    private PercentageChanceOf chanceofpartlycloudyday;
    private PercentageChanceOf tempbelowfreezing;
    private PercentageChanceOf chanceofrainday;
    private PercentageChanceOf chanceoffogday;
    private PercentageChanceOf chanceofsunnycloudyday;
    private PercentageChanceOf chanceofsnowonground;
    private PercentageChanceOf chanceoftornadoday;
    private PercentageChanceOf chanceofsultryday;
    private PercentageChanceOf chanceofhumidday;
    private PercentageChanceOf tempoversixty;
    private PercentageChanceOf tempoverninety;
    private PercentageChanceOf chanceofthunderday;
    private PercentageChanceOf chanceofhailday;

    public PercentageChanceOf getChanceofcloudyday() {
        return chanceofcloudyday;
    }

    public PercentageChanceOf getChanceoffogday() {
        return chanceoffogday;
    }

    public PercentageChanceOf getChanceofhailday() {
        return chanceofhailday;
    }

    public PercentageChanceOf getChanceofhumidday() {
        return chanceofhumidday;
    }

    public PercentageChanceOf getChanceofpartlycloudyday() {
        return chanceofpartlycloudyday;
    }

    public PercentageChanceOf getChanceofprecip() {
        return chanceofprecip;
    }

    public PercentageChanceOf getChanceofrainday() {
        return chanceofrainday;
    }

    public PercentageChanceOf getChanceofsnowday() {
        return chanceofsnowday;
    }

    public PercentageChanceOf getChanceofsnowonground() {
        return chanceofsnowonground;
    }

    public PercentageChanceOf getChanceofsultryday() {
        return chanceofsultryday;
    }

    public PercentageChanceOf getChanceofsunnycloudyday() {
        return chanceofsunnycloudyday;
    }

    public PercentageChanceOf getChanceofthunderday() {
        return chanceofthunderday;
    }

    public PercentageChanceOf getChanceoftornadoday() {
        return chanceoftornadoday;
    }

    public PercentageChanceOf getChanceofwindyday() {
        return chanceofwindyday;
    }

    public PercentageChanceOf getTempbelowfreezing() {
        return tempbelowfreezing;
    }

    public PercentageChanceOf getTempoverfreezing() {
        return tempoverfreezing;
    }

    public PercentageChanceOf getTempoverninety() {
        return tempoverninety;
    }

    public PercentageChanceOf getTempoversixty() {
        return tempoversixty;
    }
    
}
