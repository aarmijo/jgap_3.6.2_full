package com.tecnalia.epes.tamoin.wunderground.utils;

import java.net.URL;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import com.tecnalia.epes.tamoin.WindFarm;
import com.tecnalia.epes.tamoin.wunderground.connector.WundergroundConnector;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.ForecastDayExtended;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.Wind;

public class WundergroundUtils {
	/**
	 * 
	 * @param propsName
	 * @return props
	 * @throws Exception
	 */
	public static Properties load(String propsName) throws Exception {
		
		Properties props = new Properties();
		URL url = ClassLoader.getSystemResource(propsName);		
		// ClassLoader.getSystemResource(propsName) looks up a resource from the system classloader. 
		// If the url is null, the application is being run in a web environment and the resource
		// should be obtained from the web application context
		if (url == null) {
			url = Thread.currentThread().getContextClassLoader().getResource(propsName);
			//url = CmisUtils.class.getClassLoader().getResource(propsName);
		}
		props.load(url.openStream());
		return props;
	}
	
	/**
	 * 
	 * @param forecastDayArrayList 
	 * @param epochOnNextMonday
	 * @return nextMondayIndex Next Monday index
	 */
	public static int getNextMondayIndex(List<ForecastDayExtended> forecastDayArrayList) {
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
		
		int nextMondayIndex = 0;
		for (int i = 0; i < forecastDayArrayList.size(); i++) {
			if (forecastDayArrayList.get(i).getDate().getEpoch()
					.equals(String.valueOf(epochOnNextMonday))) {
				break;
			}
			nextMondayIndex += 1;
		}
		return nextMondayIndex;
	}
	
	/**
	 * 
	 * @param speedInKph 	 
	 * @return speedInMps Speed in m/s + a correction factor of 2 units
	 */
	public static int getSpeedInMps(int speedInKph) {
		double speedInMps = Double.parseDouble(String.valueOf(speedInKph))*1000/3600 + 2;		
		return (int) Math.round(speedInMps);
	}
	
	/**
	 * 
	 * @param speedInKph 	 
	 * @return speedInMps Speed in m/s + a correction factor of 2 units
	 */
	public static int[] getWindSpeeds(List<ForecastDayExtended> forecastDayArrayList) {
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
		
		int nextMondayIndex = 0;
		for (int i = 0; i < forecastDayArrayList.size(); i++) {
			if (forecastDayArrayList.get(i).getDate().getEpoch()
					.equals(String.valueOf(epochOnNextMonday))) {
				break;
			}
			nextMondayIndex += 1;
		}
		
		int windSpeedMonday = 0;
		int windSpeedTuesday = 0;
		int windSpeedWednesday = 0;
		int windSpeedThursday = 0;
		int windSpeedFriday = 0;		
        for (int i = nextMondayIndex; i < forecastDayArrayList.size(); i++) {
			Wind wind = forecastDayArrayList.get(i).getMaxwind();
			switch (i - nextMondayIndex) {
			case 0: 
				windSpeedMonday = WundergroundUtils.getSpeedInMps(wind.getKph());
				break;
			case 1: 
				windSpeedTuesday = WundergroundUtils.getSpeedInMps(wind.getKph());
				break;
			case 2: 
				windSpeedWednesday = WundergroundUtils.getSpeedInMps(wind.getKph());
				break;
			case 3: 
				windSpeedThursday = WundergroundUtils.getSpeedInMps(wind.getKph());
				break;
			case 4: 
				windSpeedFriday = WundergroundUtils.getSpeedInMps(wind.getKph());
				break;
			}
			System.out.println("Forecasted Epoch:"
					+ forecastDayArrayList.get(i).getDate().getEpoch()
					+ " Day of week:"
					+ forecastDayArrayList.get(i).getDate().getWeekday()
					+ " WindSpeed(Kph):" + wind.getKph());			
		}
		return new int[] {windSpeedMonday, windSpeedTuesday, windSpeedWednesday,
				windSpeedThursday, windSpeedFriday};
	}

	/**
	 * 
	 * @param calculateWeatherForecast Set to true if the forecast is to be extracted via external weather services 	 
	 * @param windSpeeds User defined wind speeds in (m/s) for each of the wind farms. If the calculateWeatherForecast parameter is set to true,
	 * the forecasted wind speeds extracted from the external weather services are used instead
	 * @return WindFarm[] Array that contains the WindFarm instances with the wind information updated
	 */
	public static WindFarm[] calculateWindFarms(boolean calculateWeatherForecast, int[][] windSpeeds) {
		// Set the wind farm wind conditions
		WindFarm windFarmOne = null;
		WindFarm windFarmTwo = null;
		WindFarm windFarmThree = null;			
		if (calculateWeatherForecast) {
			try {
				Properties prop;
				prop = WundergroundUtils.load("windFarmOne.config.properties");
		        WundergroundConnector wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        List<ForecastDayExtended> forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday();        
		        //int nextMondayIndex = WundergroundUtils.getNextMondayIndex(forecastDayArrayList);
		        int[] windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);

				// Wind farm one forecasted wind speed
		        windFarmOne = new WindFarm(1, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
		        
		        prop.clear();
		        prop = WundergroundUtils.load("windFarmTwo.config.properties");
		        wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday(); 
		        windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);
		        
		        // Wind farm two forecasted wind speed
		        windFarmTwo = new WindFarm(2, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
		        
		        prop.clear();
		        prop = WundergroundUtils.load("windFarmThree.config.properties");
		        wunder = new WundergroundConnector(prop);
		        wunder.getDataFromWunder();
		        forecastDayArrayList = wunder.getEnvelope().getForecast().getSimpleforecast().getForecastday(); 
		        windSpeedsArray = WundergroundUtils.getWindSpeeds(forecastDayArrayList);
		        
		        // Wind farm three forecasted wind speed
		        windFarmThree = new WindFarm(3, windSpeedsArray[0], windSpeedsArray[1], windSpeedsArray[2], 
		        		windSpeedsArray[3], windSpeedsArray[4]);
			} catch (Exception e) {
				// If there is any problem with the forecast set the windspeeds to 10 m/s
				e.printStackTrace();
				windFarmOne = new WindFarm(1, 10, 10, 10, 10, 10);
				windFarmTwo = new WindFarm(2, 10, 10, 10, 10, 10);
				windFarmThree = new WindFarm(3, 10, 10, 10, 10, 10);
			}
		} else {
			// Set the windspeeds to user selected values
			windFarmOne = new WindFarm(1, windSpeeds[0][0], windSpeeds[0][1], windSpeeds[0][2], windSpeeds[0][3], windSpeeds[0][4]);
			windFarmTwo = new WindFarm(2, windSpeeds[1][0], windSpeeds[1][1], windSpeeds[1][2], windSpeeds[1][3], windSpeeds[1][4]);
			windFarmThree = new WindFarm(3, windSpeeds[2][0], windSpeeds[2][1], windSpeeds[2][2], windSpeeds[2][3], windSpeeds[2][4]);
		}		
		return new WindFarm[] {windFarmOne, windFarmTwo, windFarmThree};
	}	
}
