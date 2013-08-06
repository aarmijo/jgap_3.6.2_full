/*
 * GsonExampleToJSON.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.htmlgenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.tecnalia.epes.tamoin.wunderground.data.envelope.WundergroundEnvelope;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.ForecastDayExtended;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.SimpleForecast;
import com.tecnalia.epes.tamoin.wunderground.data.moonphase.MoonPhase;
import com.tecnalia.epes.tamoin.wunderground.data.observations.CurrentObservation;
import com.tecnalia.epes.tamoin.wunderground.data.response.Response;

/**
 *
 * 
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: GsonExampleToJSON.java 09-01-2012 15:44:29 ttravnicek
 */
public class WundergroundHtmlGenerator {
    
    /**
     * 
     * @param propsName
     * @return
     * @throws Exception
     */
    public static Properties load(String propsName) throws Exception {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(propsName);
        props.load(url.openStream());
        return props;
    }

    /**
     * 
     * @param envelope
     * @param outputFile
     * @param templatePath
     * @throws IOException
     */
    public static void writeToHtmlFile(WundergroundEnvelope envelope, String outputFile, String templatePath) throws IOException {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        VelocityContext ctx = new VelocityContext();
        
        Response response = envelope.getResponse();
        CurrentObservation observation = envelope.getCurrent_observation();
        SimpleForecast forecast = envelope.getForecast().getSimpleforecast();
        MoonPhase moonPhase = envelope.getMoon_phase();
        
        //current observation
        ctx.put("city", observation.getDisplay_location().getFull());
        ctx.put("city_short", observation.getDisplay_location().getCity());
        ctx.put("day", observation.getLocal_time_rfc822());
        ctx.put("elevation", observation.getDisplay_location().getElevation());
        ctx.put("weather", observation.getWeather());
        ctx.put("icon_now", observation.getIcon());
        ctx.put("temperature_now", observation.getTemp_c());
        ctx.put("windchill_now", observation.getWindchill_c());
        ctx.put("winddir_now", observation.getWind_dir());
        float wind = (float) (new Float(observation.getWind_mph()) * 1.609);
        ctx.put("wind_kmh", new Float(wind).toString());
        float wind_ms = (float) (new Float(observation.getWind_mph()) * 1.609 / 3.6);
        ctx.put("wind_ms", new Float(wind_ms).toString());
        float wind_gust = (float) (new Float(observation.getWind_gust_mph()) * 1.609);
        ctx.put("wind_gust_kmh", new Float(wind_gust).toString());
        ctx.put("pressure_mb", observation.getPressure_mb());
        ctx.put("visibility_km", observation.getVisibility_km());
        ctx.put("relative_humidity", observation.getRelative_humidity());
        ctx.put("dewpoint_c", observation.getDewpoint_c());
        ctx.put("uv", observation.getUV());
        ctx.put("precip_today_string", observation.getPrecip_today_string());
        //forecast
        ArrayList list = new ArrayList();
        Map map;
        for (ForecastDayExtended day : forecast.getForecastday()) {
            map = new HashMap();
            map.put("day", day.getDate().getWeekday());
            map.put("icon", day.getIcon());
            map.put("temperature_min", day.getLow().getCelsius());
            map.put("temperature_max", day.getHigh().getCelsius());
            map.put("conditions", day.getConditions());
            map.put("pop", day.getPop());
            list.add(map);
        }
        ctx.put("forecastList", list);
        //moon
        ctx.put("sunrise", moonPhase.getSunrise().getHour()+":"+moonPhase.getSunrise().getMinute());
        ctx.put("sunset", moonPhase.getSunset().getHour()+":"+moonPhase.getSunset().getMinute());
        
        Template template = ve.getTemplate(templatePath, "windows-1250");

        FileWriter fstream = new FileWriter(outputFile);
        BufferedWriter out = new BufferedWriter(fstream);
        template.merge(ctx, out);

        out.close();
    }
}
