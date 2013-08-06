/*
 * CurrentObservations.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.data.observations;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: CurrentObservations.java 09-01-2012 16:16:58 ttravnicek
 */
public class CurrentObservation {
    private Image image;
    private Location display_location;
    private Location observation_location;
    private Estimated estimated;
    private String station_id;
    private String observation_time;
    private String observation_time_rfc822;
    private String observation_epoch;
    private String local_time_rfc822;
    private String local_epoch;
    private String local_tz_short;
    private String local_tz_long;
    private String weather;
    private String temperature_string;
    private String temp_f;
    private String temp_c;
    private String relative_humidity;
    private String wind_string;
    private String wind_dir;
    private String wind_degrees;
    private String wind_mph;
    private String wind_gust_mph;
    private String pressure_mb;
    private String pressure_in;
    private String pressure_trend;
    private String dewpoint_strin;
    private String dewpoint_f;
    private String dewpoint_c;
    private String heat_index_string;
    private String heat_index_f;
    private String heat_index_c;
    private String windchill_string;
    private String windchill_f;
    private String windchill_c;
    private String visibility_mi;
    private String visibility_km;
    private String solarradiation;
    private String UV;
    private String precip_1hr_string;
    private String precip_1hr_in;
    private String precip_1hr_metric;
    private String precip_today_string;
    private String precip_today_in;
    private String precip_today_metric;
    private String icon;
    private String icon_url;
    private String forecast_url;
    private String history_url;
    private String ob_url;

    /**
     * 
     * @return
     */
    public String getUV() {
        return UV;
    }

    /**
     * 
     * @return
     */
    public String getDewpoint_c() {
        return dewpoint_c;
    }

    /**
     * 
     * @return
     */
    public String getDewpoint_f() {
        return dewpoint_f;
    }

    /**
     * 
     * @return
     */
    public String getDewpoint_strin() {
        return dewpoint_strin;
    }

    /**
     * 
     * @return
     */
    public Location getDisplay_location() {
        return display_location;
    }

    /**
     * 
     * @return
     */
    public Estimated getEstimated() {
        return estimated;
    }

    /**
     * 
     * @return
     */
    public String getForecast_url() {
        return forecast_url;
    }

    /**
     * 
     * @return
     */
    public String getHeat_index_c() {
        return heat_index_c;
    }

    /**
     * 
     * @return
     */
    public String getHeat_index_f() {
        return heat_index_f;
    }

    /**
     * 
     * @return
     */
    public String getHeat_index_string() {
        return heat_index_string;
    }

    /**
     * 
     * @return
     */
    public String getHistory_url() {
        return history_url;
    }

    /**
     * 
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @return
     */
    public String getIcon_url() {
        return icon_url;
    }

    /**
     * 
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * 
     * @return
     */
    public String getLocal_epoch() {
        return local_epoch;
    }

    /**
     * 
     * @return
     */
    public String getLocal_time_rfc822() {
        return local_time_rfc822;
    }

    /**
     * 
     * @return
     */
    public String getLocal_tz_long() {
        return local_tz_long;
    }

    /**
     * 
     * @return
     */
    public String getLocal_tz_short() {
        return local_tz_short;
    }

    /**
     * 
     * @return
     */
    public String getOb_url() {
        return ob_url;
    }

    /**
     * 
     * @return
     */
    public String getObservation_epoch() {
        return observation_epoch;
    }

    /**
     * 
     * @return
     */
    public Location getObservation_location() {
        return observation_location;
    }

    /**
     * 
     * @return
     */
    public String getObservation_time() {
        return observation_time;
    }

    /**
     * 
     * @return
     */
    public String getObservation_time_rfc822() {
        return observation_time_rfc822;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_1hr_in() {
        return precip_1hr_in;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_1hr_metric() {
        return precip_1hr_metric;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_1hr_string() {
        return precip_1hr_string;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_today_in() {
        return precip_today_in;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_today_metric() {
        return precip_today_metric;
    }

    /**
     * 
     * @return
     */
    public String getPrecip_today_string() {
        return precip_today_string;
    }

    /**
     * 
     * @return
     */
    public String getPressure_in() {
        return pressure_in;
    }

    /**
     * 
     * @return
     */
    public String getPressure_mb() {
        return pressure_mb;
    }

    /**
     * 
     * @return
     */
    public String getPressure_trend() {
        return pressure_trend;
    }

    /**
     * 
     * @return
     */
    public String getRelative_humidity() {
        return relative_humidity;
    }

    /**
     * 
     * @return
     */
    public String getSolarradiation() {
        return solarradiation;
    }

    /**
     * 
     * @return
     */
    public String getStation_id() {
        return station_id;
    }

    /**
     * 
     * @return
     */
    public String getTemp_c() {
        return temp_c;
    }

    /**
     * 
     * @return
     */
    public String getTemp_f() {
        return temp_f;
    }

    /**
     * 
     * @return
     */
    public String getTemperature_string() {
        return temperature_string;
    }

    /**
     * 
     * @return
     */
    public String getVisibility_km() {
        return visibility_km;
    }

    /**
     * 
     * @return
     */
    public String getVisibility_mi() {
        return visibility_mi;
    }

    /**
     * 
     * @return
     */
    public String getWeather() {
        return weather;
    }

    /**
     * 
     * @return
     */
    public String getWind_degrees() {
        return wind_degrees;
    }

    /**
     * 
     * @return
     */
    public String getWind_dir() {
        return wind_dir;
    }

    /**
     * 
     * @return
     */
    public String getWind_gust_mph() {
        return wind_gust_mph;
    }

    /**
     * 
     * @return
     */
    public String getWind_mph() {
        return wind_mph;
    }

    /**
     * 
     * @return
     */
    public String getWind_string() {
        return wind_string;
    }

    /**
     * 
     * @return
     */
    public String getWindchill_c() {
        return windchill_c;
    }

    /**
     * 
     * @return
     */
    public String getWindchill_f() {
        return windchill_f;
    }

    /**
     * 
     * @return
     */
    public String getWindchill_string() {
        return windchill_string;
    }
    
    

}
