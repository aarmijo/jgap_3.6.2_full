package com.tecnalia.epes.tamoin.wunderground.utils;

import java.net.URL;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

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
}
