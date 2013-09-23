package org.epes.sgm.pojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SchedulerInput {	

	@SuppressWarnings("serial")
	private ArrayList<Map<String, String>> generalParameters = new ArrayList<Map<String, String>>() {
		{
			add(new HashMap<String, String>() {{put("readXlsFromVCN", "");}});
			add(new HashMap<String, String>() {{put("saveGanttChartToVCN", "");}});
		}
	};
	
	@SuppressWarnings("serial")
	private ArrayList<Map<String, String>> forecastParameters = new ArrayList<Map<String, String>>() {
		{
			add(new HashMap<String, String>() {{put("calculateWeatherForecast", "");}});
			add(new HashMap<String, String>() {{put("windFarmOneWindSpeedMonday", "");}});
			add(new HashMap<String, String>() {{put("windFarmOneWindSpeedTuesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmOneWindSpeedWednesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmOneWindSpeedThursday", "");}});
			add(new HashMap<String, String>() {{put("windFarmOneWindSpeedFriday", "");}});
			add(new HashMap<String, String>() {{put("windFarmTwoWindSpeedMonday", "");}});
			add(new HashMap<String, String>() {{put("windFarmTwoWindSpeedTuesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmTwoWindSpeedWednesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmTwoWindSpeedThursday", "");}});
			add(new HashMap<String, String>() {{put("windFarmTwoWindSpeedFriday", "");}});
			add(new HashMap<String, String>() {{put("windFarmThreeWindSpeedMonday", "");}});
			add(new HashMap<String, String>() {{put("windFarmThreeWindSpeedTuesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmThreeWindSpeedWednesday", "");}});
			add(new HashMap<String, String>() {{put("windFarmThreeWindSpeedThursday", "");}});
			add(new HashMap<String, String>() {{put("windFarmThreeWindSpeedFriday", "");}});
		}
	};
	
	@SuppressWarnings("serial")
	private ArrayList<Map<String, String>> optimizationPerspectiveParameters = new ArrayList<Map<String, String>>() {
		{
			add(new HashMap<String, String>() {{put("optimizeCosts", "");}});
			add(new HashMap<String, String>() {{put("optimizeAvailability", "");}});
		}
	};
	
	private String weekNumber;
		
	public ArrayList<Map<String, String>> getGeneralParameters() {
		return generalParameters;
	}

	public void setGeneralParameters(
			ArrayList<Map<String, String>> generalParameters) {
		this.generalParameters = generalParameters;
	}
	
	public ArrayList<Map<String, String>> getForecastParameters() {
		return forecastParameters;
	}

	public void setForecastParameters(ArrayList<Map<String, String>> forecastParameters) {
		this.forecastParameters = forecastParameters;
	}	
	
	public ArrayList<Map<String, String>> getOptimizationPerspectiveParameters() {
		return optimizationPerspectiveParameters;
	}

	public void setOptimizationPerspectiveParameters(
			ArrayList<Map<String, String>> optimizationPerspectiveParameters) {
		this.optimizationPerspectiveParameters = optimizationPerspectiveParameters;
	}	
	
	public String getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}	
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();			
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return "SchedulerInput [generalParameters=" + generalParameters + 
				", forecastParameters=" + forecastParameters + 
				", optimizationPerspectiveParameters=" + optimizationPerspectiveParameters + 
				", weekNumber=" + weekNumber + "]";
	}
}
