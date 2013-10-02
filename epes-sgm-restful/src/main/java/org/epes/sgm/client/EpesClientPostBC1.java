package org.epes.sgm.client;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.epes.sgm.pojo.SchedulerInput;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EpesClientPostBC1 {

	public static void main(String[] args) {

		try {			
			
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/epes-sgm-restful/rest/optimize/bc1/post");

			JSONObject input = new JSONObject();			
			
			// General parameters
			JSONObject readXlsFromVCN = new JSONObject();
			readXlsFromVCN.put("readXlsFromVCN", true);
			JSONObject saveGanttChartToVCN = new JSONObject();
			saveGanttChartToVCN.put("saveGanttChartToVCN", true);
			JSONObject leverageBC1ContentModel = new JSONObject();
			leverageBC1ContentModel.put("leverageBC1ContentModel", false);
			
			JSONArray inputList = new JSONArray();
			inputList.put(readXlsFromVCN);
			inputList.put(saveGanttChartToVCN);
			inputList.put(leverageBC1ContentModel);
			
			input.put("generalParameters", inputList);
			
			// Forecast parameters
			JSONObject calculateWeatherForecast = new JSONObject();
			calculateWeatherForecast.put("calculateWeatherForecast", false);
			JSONObject windFarmOneWindSpeedMonday = new JSONObject();
			windFarmOneWindSpeedMonday.put("windFarmOneWindSpeedMonday", 10);
			JSONObject windFarmOneWindSpeedTuesday = new JSONObject();
			windFarmOneWindSpeedTuesday.put("windFarmOneWindSpeedTuesday", 10);
			JSONObject windFarmOneWindSpeedWednesday = new JSONObject();
			windFarmOneWindSpeedWednesday.put("windFarmOneWindSpeedWednesday", 10);
			JSONObject windFarmOneWindSpeedThursday = new JSONObject();
			windFarmOneWindSpeedThursday.put("windFarmOneWindSpeedThursday", 10);
			JSONObject windFarmOneWindSpeedFriday = new JSONObject();
			windFarmOneWindSpeedFriday.put("windFarmOneWindSpeedFriday", 10);
			JSONObject windFarmTwoWindSpeedMonday = new JSONObject();
			windFarmTwoWindSpeedMonday.put("windFarmTwoWindSpeedMonday", 10);
			JSONObject windFarmTwoWindSpeedTuesday = new JSONObject();
			windFarmTwoWindSpeedTuesday.put("windFarmTwoWindSpeedTuesday", 10);
			JSONObject windFarmTwoWindSpeedWednesday = new JSONObject();
			windFarmTwoWindSpeedWednesday.put("windFarmTwoWindSpeedWednesday", 10);
			JSONObject windFarmTwoWindSpeedThursday = new JSONObject();
			windFarmTwoWindSpeedThursday.put("windFarmTwoWindSpeedThursday", 10);
			JSONObject windFarmTwoWindSpeedFriday = new JSONObject();
			windFarmTwoWindSpeedFriday.put("windFarmTwoWindSpeedFriday", 10);
			JSONObject windFarmThreeWindSpeedMonday = new JSONObject();
			windFarmThreeWindSpeedMonday.put("windFarmThreeWindSpeedMonday", 10);
			JSONObject windFarmThreeWindSpeedTuesday = new JSONObject();
			windFarmThreeWindSpeedTuesday.put("windFarmThreeWindSpeedTuesday", 10);
			JSONObject windFarmThreeWindSpeedWednesday = new JSONObject();
			windFarmThreeWindSpeedWednesday.put("windFarmThreeWindSpeedWednesday", 10);
			JSONObject windFarmThreeWindSpeedThursday = new JSONObject();
			windFarmThreeWindSpeedThursday.put("windFarmThreeWindSpeedThursday", 10);
			JSONObject windFarmThreeWindSpeedFriday = new JSONObject();
			windFarmThreeWindSpeedFriday.put("windFarmThreeWindSpeedFriday", 10);
			
			inputList = new JSONArray();
			
			inputList.put(calculateWeatherForecast).put(windFarmOneWindSpeedMonday)
			.put(windFarmOneWindSpeedTuesday).put(windFarmOneWindSpeedWednesday)
			.put(windFarmOneWindSpeedThursday).put(windFarmOneWindSpeedFriday)
			.put(windFarmTwoWindSpeedMonday)
			.put(windFarmTwoWindSpeedTuesday).put(windFarmTwoWindSpeedWednesday)
			.put(windFarmTwoWindSpeedThursday).put(windFarmTwoWindSpeedFriday)			
			.put(windFarmThreeWindSpeedMonday)
			.put(windFarmThreeWindSpeedTuesday).put(windFarmThreeWindSpeedWednesday)
			.put(windFarmThreeWindSpeedThursday).put(windFarmThreeWindSpeedFriday);
			
			input.put("forecastParameters", inputList);
			
			// optimization perspective parameters
			JSONObject optimizeCosts = new JSONObject();
			optimizeCosts.put("optimizeCosts", true);
			JSONObject optimizeAvailability = new JSONObject();
			optimizeAvailability.put("optimizeAvailability", true);
			
			inputList = new JSONArray();
			inputList.put(optimizeCosts).put(optimizeAvailability);
			
			input.put("optimizationPerspectiveParameters", inputList);
			
			// week number parameter
			input.put("weekNumber", "01");
			
			//System.out.println(input.toString());			
			ObjectMapper mapper = new ObjectMapper();
			SchedulerInput schedulerInput = mapper.readValue(input.toString(), SchedulerInput.class);
			System.out.println("Optimization Service Input parameters:");
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schedulerInput));
						
			ClientResponse response = webResource.type("application/json").accept("application/json")
					.post(ClientResponse.class, input.toString());

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);
			
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
