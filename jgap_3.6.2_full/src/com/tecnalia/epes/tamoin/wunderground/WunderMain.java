/*
 * GsonExampleToJSON.java
 * 
 * Created on 09-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tecnalia.epes.tamoin.wunderground.connector.WundergroundConnector;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.ForecastDayExtended;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.Wind;
import com.tecnalia.epes.tamoin.wunderground.data.response.Result;
import com.tecnalia.epes.tamoin.wunderground.htmlgenerator.WundergroundHtmlGenerator;

/**
 *
 * 
 * http://api.wunderground.com/api/7ae390ca98247094/astronomy/q/liberec.json
 * http://api.wunderground.com/api/7ae390ca98247094/conditions/forecast/astronomy/lang:CZ/q/CZ/liberec.json
 * 
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: GsonExampleToJSON.java 09-01-2012 15:44:29 ttravnicek
 */
public class WunderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Properties prop = WundergroundHtmlGenerator.load("config.properties");
            WundergroundConnector wunder = new WundergroundConnector(prop);
            
            //wunder.getAutocompleteDataFromWunder();
            //wunder.getAutocompleteHurricaneDataFromWunder();
            
            wunder.getDataFromWunder();
            List<ForecastDayExtended> forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday();
            if (forecastDayArrayList != null) {
				Calendar now = Calendar.getInstance();  
				int weekday = now.get(Calendar.DAY_OF_WEEK);  
				if (weekday != Calendar.MONDAY)  
				{  
				    // calculate how much to add  
				    // the 2 is the difference between Saturday and Monday  
				    int days = (Calendar.SATURDAY - weekday + 2) % 7;  
				    now.add(Calendar.DAY_OF_YEAR, days);  
				    now.set(Calendar.HOUR_OF_DAY, 23);
					now.set(Calendar.MINUTE, 0);
					now.set(Calendar.SECOND, 0);
				}  
				if (weekday == Calendar.MONDAY) {
					now.set(Calendar.HOUR_OF_DAY, 23);
					now.set(Calendar.MINUTE, 0);
					now.set(Calendar.SECOND, 0);
				}
				long epochOnNextMonday = now.getTimeInMillis()/1000L;
				System.out.println("Epoch next Monday:" + epochOnNextMonday);
				
				int firstMondayIndex = 0;
				for (int i = 0; i < forecastDayArrayList.size(); i++) {
					if (forecastDayArrayList.get(i).getDate().getEpoch().equals(String.valueOf(epochOnNextMonday))){
						break;
					}
					firstMondayIndex += 1;
				}
				
				for (int i = firstMondayIndex; i < forecastDayArrayList.size(); i++) {
					Wind wind = forecastDayArrayList.get(i).getMaxwind();
                	System.out.println("Forecasted Epoch:" + forecastDayArrayList.get(i).getDate().getEpoch() + 
                			" Day of week:" + forecastDayArrayList.get(i).getDate().getWeekday() + 
                			" WindSpeed(Kph):" + wind.getKph());
				}
            }
            
            //WundergroundHtmlGenerator.writeToHtmlFile(wunder.getEnvelope(), prop.getProperty("outputHtmlPath"), prop.getProperty("templatePath"));
            
            //System.out.println(wunder.getMoonPhase().getCurrent_time().getHour() + ":" + wunder.getMoonPhase().getCurrent_time().getMinute());
        } catch (Exception ex) {
            Logger.getLogger(WunderMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
